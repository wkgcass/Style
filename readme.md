点击[这里](http://blog.cassite.net/JAVA/Style)或[这里](Style1CN.md)获取中文文档

#Style

Bring efficient coding style from other languages to JAVA 8.

*Style* is a library that simulates programming in other languages with carefully choosen method/class names.

*Style* focuses on making your code prettier, less reinventing--wheels and well-understood.
>Referenced languages : Scala, PHP, JavaScript, Groovy, C++, and C#.

#Why Style?

Style is a free, light-weight, and open-source project with detailed tutorial.  
I am using *Style* everywhere since I built it.

#Preview

	// define a function to see if list contain a person with given name:
	def<Boolean> check = $(
			(List<Person> ls, String name) -> null != $(list).forEach(e -> {
				if (e.name().equals(name))
					return true;
				return null;
			}));
	check.apply(list, "cass");

	// If expression with return value:
	System.out.println(If(
		$(list).findOne(e -> e.name().equals("cass")),
			res -> {
				return res.id();
			}).Else(() -> "Not Found!"));

	// forEach with iterator info
	$(list).forEach((e, i) -> System.out.println(
			"Element is:" + e + " Index is:" + $(i)));
			
	// dozens of new features waiting for you to explore.
	
Fell free to contact me through [wkgcass@hotmail.com](mailto:wkgcass@hotmail.com).  
And pls execuse me for my poor english...

#Update
1.0.1 --> 1.0.2

* Now Enhanced If expression can receive lambda as its first argument.
* functions can receive more or less values than its argument length.
* StringFuncSup.fill has changed to directly invoking Message.fill
* Dynamic Proxy Simplify
* Read-Only objects
* use arrays to simulate JSON and generate a map
* Document Revision
* BUG solved:
	* Async.onError or AsyncGroup.onError used to have a chance to lock current thread forever in few cases.

#Directory

* Starting
* Functions
	* Supporting Interfaces
	* Define
	* Call
	* Async, Await and Exception Handling
		* Callback
* Language
	* Basic
		* Exceptions
		* Type Conversion
		* Pointers
		* var
	* Reflection
		* Class
		* Constructor
		* Field
		* Method
		* Dynamic Proxy
			* Read-Only objects
	* Thread
		* callback
		* (async)
		* original thread simplify
	* Logic
		* If
		* Switch
		* For
			* For-to-step
		* While
		* Control
			* Break
				* BreakWithResult
			* Continue
			* Remove
			* (List-Only)
				* Set
				* Add
* Iteration
	* Constructing
	* forEach/forThose
	* to-via Collection Transform
	* find
* Other
	* Avoid Null
	* Date
	* RegEx
	* Comparable
	* Rand
	* String
	* JSON
* Appendix
	* last loop result

#Starting

1. import *net.cassite.style.jar*
2. Create a Class, let it implements *net.cassite.style.var*  
	e.g.
	
		class YourClass implements var{}
	
	If you need to use *Style* in a static method, you need to let your class extends *net.cassite.style.Style*  
	e.g.
	
		public class YourClass extends Style{
			public static void main(String[] args){
				...
			}
		}
		
3. In other cases, you have to use *Style.(methods)* to use *Style*  
	e.g.
	
		Style.$(list).forEach(e->...);
		
>The following turtorial are using *extends* method.

#Functions

##Supporting Interfaces

Interfaces look like this:
	
	@FunctionalInterface
	public interface RFunc2<R, T0, T1> {
		R apply(T0 arg0, T1 arg1) throws Throwable;
	}

8 interfaces with return value and 8 interfaces without return value are built in, you can see them in *net.cassite.style.interfaces*.

##Define

The definition is similar to Scala or JavaScript

	def<ReturnType> funcName=$(Interface);
	// or
	def<ReturnType> funcName=function(Interface);
	
e.g.
	
	def<Boolean> check = $(
		(List<Person> ls, String name) -> null != $(list).forEach(e -> {
			if (e.name().equals(name))
				return true;
			return null;
		}));
##Call

Use *apply* to call a function on caller's thread.

e.g.
	
	check.apply(list, "cass");
	
Functions can receive more or less values than its argument length.

e.g.
	
	check.apply(list, "cass", "arg"); 
	// "arg" will be ignored
	check.apply(list) 
	// same as 'check.apply(list, null)'
	
##Async, Await and Exception Handling

Async, Await is a great multi-thread model. With *Style* you can use async/await with no extra code.

Use *async* to async-call a function, a *Async* object would be returned. You can retrieve value using *.await()*  
e.g.

	Async<Boolean> async = check.async(list, "cass");
	Boolean res = async.await(); // retrieve value;
	// or
	res = await(async);
	
When calling *await*, the curren thread would pause until async mission finished or thrown with an exception.

To handle exception from async, you can set a listener function to *Async* object.

e.g.

	async.onError((err) -> err.origin().printStackTrace());
	
>Type of 'err' is StyleRuntimeException, all exceptions from async-call would be packed with StyleRuntimeException.

The handling process would invoke immediately if async-process finished or thrown with an exception when calling *onError*.  
Or it will wait until process finishes or throws with exceptions, and deal with *err* on Async Thread.

If you want to handle the exception on caller's thread, you can invoke *awaitError* instead

e.g.
	
	async.awaitError((err)->...);
	
It would block the thread until async process finished or thrown with an exception.

###Callback

Call back is used everywhere in JavaScript

It's very easy to use callback method to deal with multi-thread programming.

Method *async* means you can call a function on another thread, so put a callback function into async-function arguments and invoke it inside the async-function would achieve calling-back.

#Language
##Basic
###Exceptions
*Style* provides an easy way of handling exceptions with StyleRuntimeException.

Usually we throw an exception in this way:

	throw new RuntimeException(e);
	
With *Style*, you can

	throw $(e);
	
then, a StyleRuntimeException would be thrown.
>If (e instance of StyleRuntimeException), the $(e) would simply return object *e* without packing.

StyleRuntimeException provides method *origin()* to get packed Throwable object.  
And it @Override getCause() method,

* if origin() instanceof InvocationTargetException
	* return .getTargetException();
* else
	* return .getCause();

Because InvocationTargetException usually hide exception you need to retrieve. I used to spend 3 hours on trying to find an error, which turned out to be hidden by InvocationTargetException.

###Type Conversion
Type conversion can take many lines and mix with other logics.

*Style* helps you convert types easily.

To use type conversion,   
the class to **convert to** may contain methods like:

	public TO_TYPE static from(FROM_TYPE obj){...}
	
**Or** the class of the object to convert may contain methods like:

	public TO_TPYE toTO_TYPE(){...}
	
e.g.  
The following definition means you can convert String to User or convert User to String.

	class User{
		static User from(String s)...
		String toString()...
	}
	 
Invoke *<T> T imp(Object, Class<T>)* to finish the conversion.

It separeates converting process from real logics, and make your code prettier.

###Pointers
Java don't have pointers for us to use. But with a object packing another object, here's our pointer.

	ptr<T> p=ptr(T t);
	$(p) // get value from the pointer, like *p in C++
	$(p, T newValue) // set value of the pointer, like *p=newValue in C++
	
Also, you can access the packed object using :

	p.item
	
Pointers may be helpful when dealing with non-final variables using anoymous classes.

###var
var often appears in js,C#...

You can see an interface named *net.cassite.style.var*.

So you can write something like this:

	class X implements var{...}
	var x=new X(...);
	
var provides default methods same as class *Style* provided.

But there're 2 more methods to simplify writings using var:

	<T> T var.$(); // use this when an method require type X
	<T> T var.$(Class<T>) // use this to force type conversion
	
##Reflection
This *Style* version(1.0.1) only support few new features about reflect.

More features will come out in the next version.

Classes/Fields/Methods/Constructors are packed into a *supporting object*. Check packet *net.cassite.style.reflect* for more info.

###Class
We used to write this:

	obj.getClass();
	TYPE_NAME.class;
	Class.forName(className);
	
Now, you can retrieve a *class supporting object* using

	ClassSup<?> cls = cls(obj);
	ClassSup<TYPE> cls = cls(TYPE.class);
	ClassSup<?> cls = cls(className);

ClassSup let you easily get *Generic Supported* constructors', fields', and methods' supporting objects.

	// no args
	ConstructorSup<TYPE> con = cls.constructor();
	// with args
	ConstructorSup<TYPE> con = cls.constructor(T0.class, T1.class, ...);

	FieldSupport<FIELD_TYPE, TYPE> f = cls.field(fieldName, FIELD_TYPE.class);
	
	// no args
	MethodSupport<RETURN_TYPE, TYPE> f m = cls.method(methodName, RETURN_TYPE.class);
	// with args
	MethodSupport<RETURN_TYPE, TYPE> f m = cls.method(methodName, RETURN_TYPE.class, T0.class, T1.class, ...);
	
Also, you can get all declaired methods or fields from the class and its super classes.

	List<FieldSup<?, TYPE>> list=cls.allFields();
	List<MethodSup<?, TYPE>> list=cls.allMethods();
	
###Constructor
You can create an instance with constructor supporting object.

	TYPE o = con.newInstance();
	TYPE o = con.newInstance(arg0, arg1, arg2, ...);
	
###Field

	FIELD_TYPE v = f.get((TYPE)obj);
	
###Method

	RETURN_TYPE r = m.invoke((TYPE)obj);
	RETURN_TYPE r = m.invoke((TYPE)obj, arg0, arg1, arg2, ...);
	
>There's no need for setAccessible(true), *Style* has done that for you.

All these supporting classes contain methods like

	isPublic()
	isStatic()
	isFinal()
	...(9 more)

which help you check modifiers.

###Dynamic Proxy

We used to create a dynamic proxy in this way:

	Proxy.newProxyInstance(
		toProxy.getClass().getClassLoader()
		, toProxy.getClass().getInterfaces()
		,handler);
Though JDK designed it this way for better reusable programming. But usually we don't need too many features.

As a result, it contains many repeating codes. *Style* helps you simplify this operation.

	<T> T proxy(handler, toProxy);
	
Also，*Style* provide aother way.  
Use List.get method as an example

* Use anoymous class to create a ProxyHandler instance:
		
		ProxyHandler<List<String>> handler = new ProxyHandler<List<String>>(list) {
			@SuppressWarnings("unused")
			String get(int index) {
				System.out.println("before get invoked with arg0:" + index);
				String res = target.get(index);
				System.out.println("after get invoked with res:" + res);
				return res;
			}
		};
	
	>
	>ProxyHandler receive an object as the object to proxy, it's stored in a field called target.
	>
	>As you can see, it uses **RETURN_TYPE methodName(Args)** to define an 'Around' proxy. This method looks exactly the same as the method to proxy.
	
* generate

		List<String> listProxy = proxy(handler);
		
this way makes proxy more readable.

####Read-Only objects
Usually, we need to create readonly objects in case someone change them. 
>e.g. We may have to pack an object into another and expose it to other modules. However we cannot guarantee other people not changing it.

*Style* provides you a easy way of turning an object with interfaces into a read-only one.

Usually it doesn't require you doing any extra work.  

	R readOnly(R r);

When an invocation comes, *Style* will check the method.

* if methodName.contains elements in $.readOnlyToSearch
	* Check whether the method has ReadOnly annotation
		* if has
			* do invoking
		* else
			* throw an exception(ModifyReadOnlyException)
* else
	* Check whether the method has Writable annotation
		* if has
			* throw an exception(ModifyReadOnlyException)
		* else
			* do invoking
	
##Thread
###callback
We have seen callback from one async object.

If more than one async tasks should be 'joined together', you can use this:

	$(Async1, Async2, Async3,...)
		.callback((res1,res2,res3,...)
		.onError(err->...); // optional
		
The callback method would invoke on a new thread.

If you need to force callback process on current thread, you can invoke

	.callbackSync(...)
	
instead.

###original thread simplify

When we create a thread, we usually write :

	Thread t=new Thread(()->{...});
	t.start();
	
*Style* can simplify the process :

	Thread t = run(()->{...});
	
The thread will start running. No need for .start()

##Logic

*Style* provide logic-control expression with return values.

###If


The way of using 'If' is similar to ordinary if-expression.

	If(INIT, (e)->{do something...})
		.ElseIf(INIT, ()->{do something...})
		.Else(()->{do something...});
		
* If INIT!=null && !INIT.equals(false)
	* apply the second argument
		* if the function has no args
			* apply anyway.
			
					func.apply();
		* else
			* apply with INIT
				
					func.apply(INIT);
* else
	* process expressions defined in elseif and else block.

INIT can also be a lambda expression. e.g. ()->INIT or more complex expressions.

>The If expression can also end with *End()* instead of Else(()->{})
>
>If Expression Return Value is [applied function's return value] or given variable.
>
>The expression to apply can also be variables. Return value would be these variables instead.

e.g.

	If(3 > 4, 1)
		.ElseIf(3 > 2, () -> 2)
		.ElseIf(4 > 3, 5)
		.Else(3);
	// will return Integer.
	
	If(1 > 2, () -> System.out.println(1))
		.ElseIf(3 > 2, () -> System.out.println(2))
		.Else(() -> System.out.println(3));
	// void functions in if-expression will return null

###Switch

	Switch(TO_SWITCH) 
	// or Switch(TO_SWITCH, Class<RETURN_TYPE>) if return type is not input type
		.Case(TO_TEST, ()->{...})
		.Case(TO_TEST, ()->{...})
		.Default(()->{...})

>Switch doesn't require break.
>
>Similar to If, functions can be replaced by variables.

e.g.
		
	String str = Switch(6, String.class)
		.Case(7, () -> "g")
		.Case(6, "f")
		.Default(() -> null);

###For

	For(T t, t->{boolean}, t->{increment}, t->{loop});
	
>For make last not null loop result as its return value.
>
>if loop result is null, it won't overwrite 'last loop result'.

Maybe you want to retrieve last loop result, *Style* provide this kind of support, do it this way:

	For(T t, t->{boolean}, t->{increment}, 
		(t,info)->{loop}); // info contains last loop result
		
	/* 
		info.currentIndex
		info.effectiveIndex // how many time 'last loop result' was modified
		info.lastRes // value of 'last loop result'
	*/
		

####For-to-step
In BASIC, a for expression was provided as :
	
	FOR i=0 TO 11 STEP 2
		...
	END FOR

It has the same function as :

	for(int i=0; i<=11; i+=2){
		...
	}

*Style* provide this kind of for-expression. It's very useful when start and end positions are fixed.

	For(NumStart).to(NumEnd).step(NumStep).loop(i->{...});
	
e.g.

	For(1).to(21).step(2).loop((Integer i, LoopInfo info) -> {...});
	// which means for(int i=1;i<=21;i+=2){...}
	// info is optional

It also has return value. The behavior is the same as For.
	
it really help save a lot of coding. Scala uses expressions with return value.


####While

	While(()->{boolean}, ()->{loop});
	
Similarly, you can retrieve 'last loop result' using

	While(()->{boolean}, info->{loop});
	
The return value behavior is the same as For.

###Control

These loops cannot break in an ordinary way.

So i think it's the best way to control loops with exceptions.

####Break
Break the loop instantly

	return Break(); // or simply 'Break();' if no compiling errors.
	// or
	throw new Break();
	
####BreakWithResult
Break the loop after setting 'last loop value'.

	return BreakWithResult(R res); // or BreakWithResult(R res)
	// or
	throw new BreakWithResult(R res);

####Continue
Jump to the next loop without writing 'last loop result'.

	return Continue(); // or Continue();
	// or
	throw new Continue();
	// or
	return null;

####Remove
Invoke the current iterator's .remove() method.

Only use in $(iterator).forEach

	return Remove(); // or Remove();
	// or
	throw new Remove();

####(List-Only)
ListIterator provide more functions. Such as Set, and Add
#####Set
Invoke ListIterator's set method.

	return Set(T toSet); // or Set(T toSet)
	// or
	throw new $Set(T toSet);

#####Add
Invoke ListIterator's add method.

	return Add(T toSet); // or Add(T toSet)
	// or
	throw new Add(T toSet);

#Iteration
##Constructing
It's easy for an Array to initiate with values using new T[]{...};

However collections and maps are much difficut.

*Style* solved the problem.

	$(new ArrayList<String>(), "hello", "world", "!");
	
would add 3 strings into given collection.

	$(new HashMap<String, Integer>(), 
		map("a", 1).$("b", 2).$("c", 3));
		
would put 3 entries into given map.

>You can also add/put elements/entries into already existed collections/maps in the same way.

##forEach/forThose

JDK1.8 provide iterable objects with forEach and filter, however, they donot have return values, and they cannot be breaked out. They cannot work on an array, and they don't supply iteration info.
>you can use if to achieve similar result but the code doesn't look good.

*Style* give Arrays, Iterables, and Maps the ability of using more advanced forEach.

Arrays, Iterables:

	$(arr).forEach(e->{...});
	// with iterator info
	/*
		info.currentIndex;
		info.previousIndex;
		info.nextIndex;
		info.hasPrevious;
		info.hasNext;
		info.lastRes // result from last loop
	*/
	$(arr).forEach((e, i)->{...});
	$(arr).forThose(e->{boolean}, e->{...});
	$(arr).forThose(e->{boolean}, (e, i)->{...});
	
Maps:

	$(map).forEach((k,v)->{...});
	$(map).forEach((k,v,i)->{...}); // with iterator info
	$(map).forThose((k,v)->{boolean}, (k,v)->{...});
	$(map).forThose((k,v)->{boolean}, (k,v,i)->{...});
	
Return value have the same behavior as For

>Array, Iterable, and Map support 'Break', 'Continue' and 'BreakWithResult'
>
>Iterable and Map support control exception 'Remvoe'
>
>List support control exception 'Set' and 'Add'

e.g.

	strArr = new String[] {
		"a", "b", "c", "d"
	};
	$(strArr).forEach(e -> {
		if (e.equals("b"))
			Continue();
		if (e.equals("d"))
			Break();
		return e;
	});
	// the result is "c"
	
	map = $(new HashMap<String, Integer>()
		, map("cass", 1995).$("john", 1996).$("alpha", 1994));
	$(map).forEach((k, v, i) -> {
		if (k.equals("alpha"))
			Remove();
		System.out.println("key is:" + k + " value is:" + v + " current index is:" + $(i));
	});
	// the result is null (because there are no return values in the loop)
	// key is:cass value is:1995 current index is:0
	// key is:john value is:1996 current index is:2
	// it's a HashMap, the order is different from it when putting in.


##to-via Collection Transform

It's very convenient using *Style* transform from Arrays, Iterables, Maps to another Collection(Map also support transform to another Map).

	Set<String> set = $(list).to(new HashSet<String>()).via(e->e+" mark");
	// modify every element in list and put them into new set.
	
	$(map).to(new HashMap<String,Integer>()).via((k,v)->{return new Entry<String, Integer>(k.toString(), Integer.parseInt(v));});
	// change type and put into new map.

##find

Usually we need to find some elements/entries from an array, an iterable, or a map.

	$(list).findOne(e->{boolean}); 
	// return first found element, null if not found
	
	$(list).findAll(e->{boolean});
	// get all found elements and add them in a new ArrayList<>
	
	$(list).findAll(e->{boolean}, Coll);
	// get all found elements and add them in Coll
	
	$(list).findAll(e->{boolean}, Coll, int limit);
	// get all found elements and add them in Coll before Coll.size() reaches limit
	
>Map have similar behavior, return Maps or Entries instead of Collections or Elements


#Other

##Avoid Null
null is very annoying. Now，*Style* can help you avoid null values

	avoidNull(MayBeNullValue, ()->{DefaultValue});
	
if MayBeNullValue is null, avoidNull will return value of lambda expression.

##Date
Provides simplification for add/substract of date, and better toString support.

Java built-in Date modification seems to be a little to difficult.
With *Style* you can write simple and readable Date modifications.  

	$(date).add(d -> d.day(1).hour(2).minute(3).second(4).milli(5))
			.nextYear().nextMonth()
			.substract(d -> d.day(5).hour(4).minute(3).second(2).milli(1));
	System.out.println($(date).toString("YYYY-mm-dd hh:ii:ss A"));
	
for toString("") method, *Style* provide following expressions.

| **str**   | **meanings**        | **sample**|
| :---------|:-------------------:| -----:|
| s/S       | second              | 59/3  |
| ss/SS     | second              | 59/03 |
| i/I       | minute              | 59/3  |
| ii/II     | minute              | 59/03 |
| h         | 12band hour         | 11/2  |
| H         | 24band hour         | 23/2  |
| hh        | 12band hour         | 11/02 |
| HH        | 24band hour         | 23/02 |
| d/D       | date                | 27/5  |
| dd/DD     | date                | 27/05 |
| m/M       | month               |  12/1  |
| mm/MM     | month               |  12/01 |
| yy/YY     | year                |  15/95 |
| yyyy/YYYY | year                | 2015/1995 |
| a         | am/pm               |  am/pm |
| A         | AM/PM               |  AM/PM |

###RegEx
*Style* provide Reg expressions similar to JavaScript

create using *regex("/reg expression/flags")*

e.g.

	System.out.println(regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
	System.out.println(regex("/<[^>]*>/").matches("<html>"));
	System.out.println(regex("/<[^>]*>/").test("abc<html>def"));
	System.out.println(Arrays.toString(regex("/(\\d+,)(\\d+)/").exec("123,456-34,345")));

###Comparable
Usually we only need to compare two Comparable which is bigger/smaller, but don't need to know how bigger/smaller it is.

e.g.
	
	$(Comparable<T>).eq/ne/lt/gt/le/ge(T)
	// boolean : equal/not equal/littler than/greater than/littler or equal/greater or equal
	
Also,alias like neq,lte,gte are provided.

###Rand
Usually we don't simply get a double from between 0 and 1  
 
*Style* provides some functions that often used.

	rand(100) // 0 <= Integers < 100
	rand(0.125) // 0 <= Doubles < 0.125
	rand(150, 200) // 150 <= Integers <= 200
	rand(0.875, 1.0) // 0.875 <= Doubles < 1.0
	rand(string, 50) // based on string, build a random serie with 50 chars
	rand(string, 15, true) //based on string, build a random serie with 50 chars that are no repeating chars
	rand(string, 15, true, true) //based on string, build a random serie with 50 chars that are no repeating chars after ignoring cases.
	
###String
We usually have to join strings. C#(.NET) provide a simple way of joining strings. *Style* learnt from it.

e.g.
	
	$("hello, my name is {0}, let's write java with {1}!").fill("cass","Style");

will return :

	"hello, my name is cass, let's write java with Style!"
	
If you packed the variables to an object, Style provide another way :  
e.g. a class Sample

	class Sample implements var {
		private String name;
		private int age;
		public String sex;

		public Sample(String name, int age, String sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;
		}

		public String name() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public static Sample from(String str) {
			String[] strArr = str.split(";");
			return new Sample(strArr[0], Integer.parseInt(strArr[1]), strArr[2]);
		}
	}
	
You can write:

	var sample = new Sample("cass", 20, "male");
	System.out.println(
		$("My name is ${name}, I'm ${age} years old, and I'm ${sex}.")
			.from(sample));

will return

	My name is cass, I'm 20 years old, and I'm male.
	
##JSON
You can create a JSONLike object from a json-like Object array.  
e.g. you can create a JSONLike object like this:

	map(new Object[]{
		"name"	, "cass",
		"age"	, 20,
		"sex"	, "male"
	});
>JSONLike extends LinkedHashMap
			
#Appendix

##last loop result
For, For-to-step, While, forEach/forThose loops all have return values.  
when a loop finished, it may return a result to the loop controller. 

Loop controllers store a value called 'last loop value'.The controller examine the result from loop, 

if it's not null, overwrite the 'last loop value' with received result. if it's null, the controller ignore the null value and goes on.
>Loop controller is not a class, it's a method. More specificly, Style.For(i,c,inc,loop) and Style.While(c,loop). They are bases of most loops in *Style*.