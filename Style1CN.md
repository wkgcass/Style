Click [here](https://github.com/wkgcass/Style) for English tutorial

#Style

给Java8带来其他语言高效的编程风格。

*Style*通过精心挑选的方法/类名来模拟其他语言。

*Style*致力于让你的编码更加美观，进行更少的重复编码，以及提升可读性。

>本工具参考了Scala, PHP, JavaScript, Groovy, C++ 以及 C#

#为何选择Style?

Style免费，轻量级，是一个有着详细指引的开源项目。  
我本人自从编写Style以来一直在使用它。

#前瞻

	// 定义一个函数，来检查List中是否有指定的Person
	def<Boolean> check = $(
			(List<Person> ls, String name) -> null != $(list).forEach(e -> {
				if (e.name().equals(name))
					return true;
				return null;
			}));
	check.apply(list, "cass");

	// 带返回值的If表达式
	System.out.println(If(
		$(list).findOne(e -> e.name().equals("cass")),
			res -> {
				return res.id();
			}).Else(() -> "Not Found!"));

	// 提供迭代信息的forEach
	$(list).forEach((e, i) -> System.out.println(
			"Element is:" + e + " Index is:" + $(i)));
			
	// 数十种新特性等待你去发现
	
有任何问题，您可以随时通过[wkgcass@hotmail.com](mailto:wkgcass@hotmail.com)与我联系.  

#更新内容
1.1.3 --> 2.0.1

本版本更新可能导致与以往版本不兼容

* 移除了`Style`类, 并将`Core`重命名为 Style
* `Aggregation`,`Reflect`,`Utils`不再继承`Style`
* 删除var接口
* 增加Maven支持
* 完整的单元测试
* readme.md修订
* 所有无返回值的函数被定义为`def<Void>`
* [新]现在可以通过`ClassSup`调用`newInstance()`直接生成实例
* [新]现在`ClassSup`增加了一个`getters()`方法用于获取所有getter
* [新]`MInteger`增加了一个方法，用于生成包含连续整数序列的List，见文档
* [新]增加了一个方法`breakable(()->{})`提供可跳出的方法。

#目录

* 起步
* 函数式
	* 接口支持
	* 定义
	* 调用
	* Async, Await 以及异常处理
		* 回调
* 语言
	* 基本项目
		* 异常
		* 类型转换
		* 指针
		* Tuple
		* 可变包装类
	* 反射
		* 类
		* 构造函数
		* 成员
		* 方法
		* 动态代理
			* 只读对象
	* 线程
		* 回调
		* (async)
		* 原生线程简化
	* 逻辑
		* If
		* Switch
		* For
			* For-to-step
		* While
		* 逻辑控制
			* Break
				* BreakWithResult
				* breakable
			* Continue
			* Remove
			* (仅List)
				* Set
				* Add
* 迭代
	* 构建
	* forEach/forThose
	* to-via 集合转换
	* find
* 其他
	* Null消除
	* 日期
	* 正则
	* Comparable
	* Rand
	* 字符串
	* JSON
	* join
* 附录
	* 上次循环结果

#起步

1. 导入*net.cassite.style.jar*
2. 创建一个类，并加入`import static net.cassite.style.Style.*;`  
	e.g.
	
		import static net.cassite.style.Style.*;
        class YourClass {}
	
	如果你需要在一个static方法中使用*Style*，那么你需要让你的类继承*net.cassite.style.Style*  
	e.g.
	
		public class YourClass extends Style{
			public static void main(String[] args){
				...
			}
		}
		
3. 如果你需要其它模块,你也许会需要这些:

		import static net.cassite.style.Style.*;
		import static net.cassite.style.Aggregation.*;
		import static net.cassite.style.Utils.*;
		import static net.cassite.style.Reflect.*;
		
	或者这么写：
	
		Aggregation.$(list).findOne(e->...);

#函数式

##接口支持

接口类似如下样式:
	
	@FunctionalInterface
	public interface RFunc2<R, T0, T1> {
		R apply(T0 arg0, T1 arg1) throws Throwable;
	}

内建8个有返回值的接口，以及8个无返回值的接口，你可以在*net.cassite.style.interfaces*中找到它们.

##定义

定义方式与Scala或者JavaScript相似

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
##调用

使用*apply*可以在当前线程上调用这个函数。

e.g.
	
	check.apply(list, "cass");
	
函数可以接收比参数表更多或更少的参数。
	
e.g.
	
	check.apply(list, "cass", "arg"); 
	// "arg" 会被忽略
	check.apply(list) 
	// 相当于 'check.apply(list, null)'
	
使用 applyCheckPrimitive 来避免自动拆箱时遭遇null值

e.g.

	def<Boolean> predicate = function(...);
	boolean b = predicate.applyCheckPrimitive(boolean.class, arg);
	
##Async, Await 以及异常处理
Async, Await是一个非常好用的多线程模型. 你可以通过*Style*来使用Async/Await，而且不需要编写任何额外代码。

使用 *async* 来异步调用一个函数, 这将返回一个*Async*对象. 你可以通过调用*.await()*来获取返回值  
e.g.

	Async<Boolean> async = check.async(list, "cass");
	Boolean res = async.await(); // retrieve value;
	// or
	res = await(async);
	
当调用*await*时, 当前线程将阻塞直到Async线程返回值或抛出异常为止。

你可以对Async对象设置一个监听函数，用来处理来自Async线程的异常。

e.g.

	async.onError((err) -> err.origin().printStackTrace());
	
>'err'的类型是StyleRuntimeException, 所有来自Async的异常都会被包装成StyleRuntimeException.

在执行onError时，如果Async调用已经结束或者已经抛出了一个异常，那么该异常处理过程将立即执行。  
否则它将等到Async处理结束时或者抛出一个异常时再[在Async线程上]处理*err*

如果想要在调用者的线程上处理异常，你可以使用*awaitError*

e.g.
	
	async.awaitError((err)->...);
	
它将阻塞本线程直到Async过程结束或者抛出一个异常。

###回调

回调在JavaScript里大量使用。

回调让多线程编程显得非常容易。

*async*方法意味着您可以在另一个线程上调用函数, 所以为了实现回调，您可以向函数1的参数中传入一个函数2，然后在另一个线程上执行函数1。

#语言
##基本项目
###异常
*Style* 提供了一个非常简单的方法来处理异常：  
StyleRuntimeException.

通常我们会这样来抛出一个异常：

	throw new RuntimeException(e);
	
借助*Style*, 你可以

	throw $(e);
	
这样, 一个StyleRuntimeException被抛出。
>如果 (e instance of StyleRuntimeException), 那么$(e) 将直接返回*e*对象而不会再次包装.

StyleRuntimeException提供*origin()*方法，以便获取包装的Throwable对象。
StyleRuntimeException @Override getCause() 方法,

	返回 super.getCause().getCause();

###类型转换
类型转换常常和逻辑代码混杂起来。

*Style* 帮助你更轻松的转换类型。

为了使用类型转换,   
**要转换到的类型**可以有如下方法:

	public TO_TYPE static from(FROM_TYPE obj){...}
	
**或者** 被转换的对象可以有如下方法:

	public TO_TPYE toTO_TYPE(){...}
	
e.g.  
如下定义表示你可以将String转化为User， 或者从User转化为String。

	class User{
		static User from(String s)...
		String toString()...
	}
	 
调用*<T> T imp(Object, Class<T>)* 来完成转化。

这样的方式将转化逻辑与实际逻辑分离，代码会显得更好看。

###指针
Java没有指针供我们使用。 不过我们可以把“包装着一个对象的对象”看作一个指针.

	ptr<T> p=ptr(T t);
	$(p) // 从指针获取值，就像C++的*p
	$(p, T newValue) // 修改指针对应值内容, 就像C++中的*p=newValue
	
此外, 你可以通过这样的方式直接获取包裹的内容:

	p.item
	
指针在使用匿名类需要使用非final变量时会非常有用。
	
如果给定的对象拥有接口，那么一个代理对象将自动创建。  
使用 

	p.proxy
	
来获取这个代理对象。

*p.proxy*直接在*p.item*上调用方法，这使得*ptr*和C/C++的指针的行为一模一样。

###Tuple
从版本1.1.3开始提供Tuples  
他们和Scala的tuple基本一致，但多了一些方便更的方法。

使用成员变量来获取元素 *tuple._1* / *tuple._2*  
使用*tuple(e1, e2, ...)*来创建tuple

有7种内建的Tuple  
Tuple1, Tuple2, ... , Tuple7, 它们都提供*_index*来获取元素。（index从1开始）  
它们都实现*interface Tuple*

	interface Tuple{
		<T> T $(int index); // 获取元素，下标从1开始
		int count(); // Tuple的元素个数
	}

使用$(index)和*_index*会取得同样的元素  
使用*count()*作为循环结尾

e.g.

	for(int i=1;i<=tuple.count();++i){
		...
	}	

###可变包装类
提供了基本类型的可变包装。使用`Utils.$(对应类型)`获取。  

>虽然string也和其它MType在一个包下，但并不是可变包装之一，详细说明在 其它 一章中

其中MInteger类型（int的可变包装类）提供了`to(int)`和`until(int)`方法，分别用于生成包含/不包含结尾整数连续的序列。

e.g.

	$(0).to(20)

生成从0到20的序列，也就是`list(0,1,2,...,20)`

	$(0).until(20)
	
生成从0到19的序列，也就是`list(0,1,2,...,19)`

##反射

类/成员/方法/构造器被包装在*提供支持的对象*中. 查看*net.cassite.style.reflect*以获取更多信息.

###类
我们曾这样获取一个Class对象

	obj.getClass();
	TYPE_NAME.class;
	Class.forName(className);
	
现在，你可以通过

	ClassSup<?> cls = cls(obj);
	ClassSup<TYPE> cls = cls(TYPE.class);
	ClassSup<?> cls = cls(className);
	
获取一个*类支持对象*

ClassSup让你轻松的使用*支持泛型的*构造函数、成员、方法的支持对象。

	// 无参
	ConstructorSup<TYPE> con = cls.constructor();
	// 有参
	ConstructorSup<TYPE> con = cls.constructor(T0.class, T1.class, ...);

	FieldSupport<FIELD_TYPE, TYPE> f = cls.field(fieldName, FIELD_TYPE.class);
	
	// 无参
	MethodSupport<RETURN_TYPE, TYPE> f m = cls.method(methodName, RETURN_TYPE.class);
	// 有参
	MethodSupport<RETURN_TYPE, TYPE> f m = cls.method(methodName, RETURN_TYPE.class, T0.class, T1.class, ...);
	
此外，你可以获取所有本类或者父类中定义过的成员或方法

	List<FieldSup<?, TYPE>> list=cls.allFields();
	List<MethodSup<?, TYPE>> list=cls.allMethods();
	
###构造函数
你可以通过它创建一个对象实例

	TYPE o = con.newInstance();
	TYPE o = con.newInstance(arg0, arg1, arg2, ...);
	
###成员

	FIELD_TYPE v = f.get((TYPE)obj);
	
###方法

	RETURN_TYPE r = m.invoke((TYPE)obj);
	RETURN_TYPE r = m.invoke((TYPE)obj, arg0, arg1, arg2, ...);
	
>不需要手动调用setAccessible(true), *Style*以及帮你调用好了

所有*提供支持的对象*都保护如下方法以便检查标识符

	isPublic()
	isStatic()
	isFinal()
	...(9 more)
	
###动态代理

我们曾这样使用动态代理

	Proxy.newProxyInstance(
		proxyTarget.getClass().getClassLoader()
		, ProxyTarget.getClass().getInterfaces()
		,handler);
虽然JDK这样的设计是为了更好的重用，但大多数情况我们不会指定ClassLoader，不会附带额外的接口。

所以其中包含了许多重复动作。*Style*帮您简化了这种操作

	<T> T proxy(handler, proxyTarget);
	
此外，*Style*还提供另外一种更加便捷的方式，这里对List的get方法进行动态代理：

* 使用匿名类定义一个ProxyHandler对象：
		
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
	>ProxyHandler接收一个对象，以它作为被代理对象，它将存储在叫做target的成员中。
	>
	>可以看出，使用 返回类型 方法名(原方法参数) 来定义一个Around型的代理。该方法实际上和被代理方法在定义上看起来完全一样。
	
* 生成

		List<String> listProxy = proxy(handler);
		
代理过程非常轻松可读。

####只读对象
我们常常需要创建一个只读对象以防止其他人修改它。
>e.g. 我们可能会把一个对象包装起来发送到其他模块去，但并不能保证其他模块的人不会修改它

*Style* 能够方便的将一个带有接口的对象包装成只读对象。

一般来说这不会需要什么额外工作。

	R readOnly(R r);

当调用到来时，*Style* 将检查方法：

* 如果 方法名包含 $.readOnlyToSearch 中出现的元素
	* 检查该方法是否具有ReadOnly注解
		* 如果有
			* 执行调用
		* 否则
			* 抛出异常(ModifyReadOnlyException)
* 否则
	* 检查该方法是否具有Writable注解
		* 如果有
			* 抛出异常(ModifyReadOnlyException)
		* 否则
			* 执行调用

>注意，抛出的异常最终都以StyleRuntimeException为包装
	
##线程
###回调
我们已经介绍过，从对一个函数通过async使用回调

如果有多个Async需要同时返回（比如要把它们的返回值整合处理）:

	$(Async1, Async2, Async3,...)
		.callback((res1,res2,res3,...)
		.onError(err->...); // 可选的
		
callback方法将在新线程上调用。

如果你希望在本线程上调用callback，可以使用

	.callbackSync(...)

###原生线程简化

在创建线程时，我们常常会写:

	Thread t=new Thread(()->{...});
	t.start();
	
*Style* 简化了这种行为 :

	Thread t = run(()->{...});
	
新线程已经开始运行了. 不需要再手动调用 .start()

##逻辑

*Style* 提供了带返回值的逻辑控制语句.

###If

使用‘If’语句的方式和使用普通if类似

	If(INIT, (e)->{do something...})
		.ElseIf(INIT, ()->{do something...})
		.Else(()->{do something...});
		
* 如果 INIT!=null && !INIT.equals(false)
	* 执行第二个参数
		* 如果第二个参数是无参的函数
			* 直接调用
			
					func.apply();
		* 否则
			* 传入INIT以调用
				
					func.apply(INIT);
* 否则
	* 处理elseif和else中的语句.

其中，INIT也可以写成lambda表达式，比如()->INIT，或更复杂的形式。

>If表达式也可以 以*End()*结尾而不是Else(()->{})结尾
>
>表达式返回值是[被执行函数的返回值] 或 指定的变量.
>
>要执行的函数也可以替换为变量。返回值将是对应的变量。

e.g.

	If(3 > 4, 1)
		.ElseIf(3 > 2, () -> 2)
		.ElseIf(4 > 3, 5)
		.Else(3);
	// 返回一个整数
	
	If(1 > 2, () -> System.out.println(1))
		.ElseIf(3 > 2, () -> System.out.println(2))
		.Else(() -> System.out.println(3));
	// 无返回值函数的if表达式将返回null

###Switch

	Switch(TO_SWITCH) 
	// 如果返回类型和给定类型不一致 Switch(TO_SWITCH, Class<RETURN_TYPE>) 
		.Case(TO_TEST, ()->{...})
		.Case(TO_TEST, ()->{...})
		.Default(()->{...})

>Switch不需要break。
>
>与if类似，函数可以替换为变量

e.g.
		
	String str = Switch(6, String.class)
		.Case(7, () -> "g")
		.Case(6, "f")
		.Default(() -> null);

###For

	For(T t, t->{boolean}, t->{increment}, t->{loop});
	
>For的返回值为最后一个非null的loop返回值。
>
>如果loop返回null，那么“上一循环返回值”不会被覆盖。

也许你会希望获取上一循环返回值, *Style*也提供这种做法，如下所示:

	For(T t, t->{boolean}, t->{increment}, 
		(t,info)->{loop}); // info 中附带了上一循环返回值
		
	/* 
		info.currentIndex
		info.effectiveIndex // 上一循环返回值被修改过的次数
		info.lastRes // 上一循环返回值
	*/
		

####For-to-step
在BASIC中, 有一种For循环，类似这样:
	
	FOR i=0 TO 11 STEP 2
		...
	END FOR

它与如下语句有相同的功能:

	for(int i=0; i<=11; i+=2){
		...
	}

*Style*提供这样的For循环. 当初始值和结束值都确定情况下这种语句非常有用.

	For(NumStart).to(NumEnd).step(NumStep).loop(i->{...});
	
e.g.

	For(1).to(21).step(2).loop((Integer i, LoopInfo info) -> {...});
	// 也就是 for(int i=1;i<=21;i+=2){...}
	// info 也是可选的

它也具有返回值，返回行为和For一致。
	
带返回值的语句的确节省了不少代码，比如Scala就使用了带返回值的语句。


####While

	While(()->{boolean}, ()->{loop});
	
类似的, 你可以通过

	While(()->{boolean}, info->{loop});
	
获取循环信息。
	
While的返回值的行为和For一致。

###逻辑控制

这些循环无法通过常规方式跳出。

于是，我觉得最好的办法是通过异常使他们跳出循环。

####Break
直接跳出循环

	return Break(); // 不产生编译错误的话也可以直接 'Break();'
	// or
	throw new Break();

提供了一个`breakable(()->{})`方法，可以在其方法体中使用Break跳出方法块。例如

	breakable(()->{
		list.stream().filter(u -> u.age > 18).forEach(u->{
			if(u.name.equals("cass")) Break();
			System.out.println(u);
		});
	});
	
BreakWithResult也可以使用，但不会有任何特殊作用。
	
####BreakWithResult
在设置好‘上次循环结果’后跳出循环

	return BreakWithResult(R res); // or BreakWithResult(R res)
	// or
	throw new BreakWithResult(R res);

####Continue
不操作‘上次循环结果’，直接跳转下一循环

	return Continue(); // or Continue();
	// or
	throw new Continue();
	// or
	return null;

####Remove
调用当前iterator 的 .remove() 方法.

仅在 $(iterator).forEach 中使用

	return Remove(); // or Remove();
	// or
	throw new Remove();

####(仅List)
ListIterator 提供更多功能. 比如Set, 以及Add
#####Set
调用 ListIterator set 方法.

	return Set(T toSet); // or Set(T toSet)
	// or
	throw new $Set(T toSet);

#####Add
调用 ListIterator add 方法.

	return Add(T toSet); // or Add(T toSet)
	// or
	throw new Add(T toSet);

#迭代
##构建
Array通过 new T[]{...}; 可以非常方便的初始化

然而初始化Collection和Map会比较复杂。

*Style* 解决了这些问题。

	$(new ArrayList<String>(), "hello", "world", "!");
	
将会增加 3 条字符串到指定的集合中.

	list("hello","world","!");

创建了一个包含3个元素的新ArrayList。

	$(new HashMap<String, Integer>(), 
		map("a", 1).$("b", 2).$("c", 3));
		
将会put 3 个entry到指定Map中.

	map("a",1).$("b",2).$("c",3);

创建了一个JSONLike(extends LinkedHashMap)

>你也可以使用同样的方法 add/put 元素/entry 到已存在的 集合/Map.

##forEach/forThose

JDK1.8 对iterable对象提供forEach和filter方法, 但是, 它们不包含返回值，而且它们无法break出。它们无法在数组上进行操作，也不会提供迭代信息。
>你可以使用if来获取类似break的功能，但是代码看起来不好看（逻辑没有break明确）

*Style* 对数组，可迭代对象，Map 提供 forEach.

数组和可迭代对象:

	$(arr).forEach(e->{...});
	// 如果要获取迭代信息
	/*
		info.currentIndex;
		info.previousIndex;
		info.nextIndex;
		info.hasPrevious;
		info.hasNext;
		info.effectiveIndex; // 上次循环结果被修改过的次数
		info.lastRes // 上次循环结果
	*/
	$(arr).forEach((e, info)->{...});
	$(arr).forThose(e->{boolean}, e->{...});
	$(arr).forThose(e->{boolean}, (e, info)->{...});
	
Map:

	$(map).forEach((k,v)->{...});
	$(map).forEach((k,v,info)->{...}); // 加上迭代信息
	$(map).forThose((k,v)->{boolean}, (k,v)->{...});
	$(map).forThose((k,v)->{boolean}, (k,v,i)->{...});
	
该语句的返回值行为与For相同

>数组，可迭代对象，Map都支持 'Break', 'Continue' 和 'BreakWithResult'
>
>可迭代对象和Map都支持 'Remvoe'
>
>List支持 'Set' 和 'Add'

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
	// 这是一个HashMap, 顺序和加入时顺序并不相同。


##to-via 集合转换

使用*Style*将数组，可迭代对象，以及Map转换为其他的Collection(Map 也支持转换为另一个Map).

	Set<String> set = $(list).to(new HashSet<String>()).via(e->e+" mark");
	// 修改每一个元素并加入新集合中
		
	$(map).to(new HashMap<String,Integer>()).via((k,v)->{return new Entry<String, Integer>(k.toString(), Integer.parseInt(v));});
	// 修改类型并加入新Map中

##find

通常我们需要在数组，可迭代对象，Map中找出一些元素或者Entry。

	$(list).findOne(e->{boolean}); 
	// 返回第一个找到的元素，null表示没找到
	
	$(list).findAll(e->{boolean});
	// 获取所有找到的元素并把它们放入ArrayList中
	
	$(list).findAll(e->{boolean}, Coll);
	// 获取所有找到的元素并把它们放入Coll集合中
	
	$(list).findAll(e->{boolean}, Coll, int limit);
	// 在集合内容数量超过limit之前，将获取所有找到的元素并把它们放入Coll集合中
	
>Map也有类似的行为, 返回Map或者Entry 而不是 集合或者元素


#其他

##Null消除
null值非常烦人，现在，*Style*可以帮助您消除可能的null值

	avoidNull(MayBeNullValue, ()->{DefaultValue});
	
如果MayBeNullValue为null， 函数将返回后面lambda表达式的值

##日期
提供了对于日期的增，减简化，以及更优雅的格式化输出。

java的日期操作略显复杂。  
通过style，您可以写出简便易懂可读的日期(java.util.Date)操作：

	$(date).add(d -> d.day(1).hour(2).minute(3).second(4).milli(5))
			.nextYear().nextMonth()
			.substract(d -> d.day(5).hour(4).minute(3).second(2).milli(1));
	System.out.println($(date).toString("YYYY-mm-dd hh:ii:ss A"));
	
对于格式化输出，有如下可选格式：

| **字符**   | **含义**            | **样例**|
| :---------|:-------------------:| -----:|
| s/S       | 秒                  | 59/3  |
| ss/SS     | 秒，补全为两位        | 59/03 |
| i/I       | 分                  | 59/3  |
| ii/II     | 分，补全为两位        | 59/03 |
| h         | 12进制小时           | 11/2  |
| H         | 24进制小时           | 23/2  |
| hh        | 12进制小时，补全为两位 | 11/02 |
| HH        | 24进制小时，补全为两位 | 23/02 |
| d/D       | 日期                | 27/5  |
| dd/DD     | 日期，补全为两位      | 27/05 |
| m/M       | 月                 |  12/1  |
| mm/MM     | 月，补全为两位       |  12/01 |
| yy/YY     | 年，末尾两位         |  15/95 |
| yyyy/YYYY | 年                  | 2015/1995 |
| a         | am/pm              |  am/pm |
| A         | AM/PM              |  AM/PM |

##正则
提供类似JavaScript的正则表达式形式。简化了创建和使用。  
g表示全局，i表示忽略大小写，m表示多行。

通过*regex("/reg expression/flags")*创建。

使用：

	System.out.println(regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
	System.out.println(regex("/<[^>]*>/").matches("<html>"));
	System.out.println(regex("/<[^>]*>/").test("abc<html>def"));
	System.out.println(Arrays.toString(regex("/(\\d+,)(\\d+)/").exec("123,456-34,345")));

###Comparable
通常我们只需要比较两个对象的“大小”，而不必精确到“大”了多少。

用法：
	
	$(Comparable<T>).eq/ne/lt/gt/le/ge(T)
	// 返回boolean : 等于/不等于/小于/大于/小于等于/大于等于
	
为了更符合个人习惯，提供了neq,lte,gte这样的方法别名。

###Rand
平时若使用随机数，通常不会仅仅取一个0到1之间的数字。  
而是取某个值到某个值之间的随机数。  
虽然实现也很方便，但一样属于重复编码。style提供了几个常用的随机数生成方法：

	rand(100) // 100以内的随机整数（不包括100）
	rand(0.125) // 0.125以内的随机双精度数（不包括0.125)
	rand(150, 200) // 150到200之间的随机整数（包括150和200）
	rand(0.875, 1.0) // 0.875到1.0之间的随机双精度数（包括0.875，不包括1.0）
	rand(string, 50) // 以string为模板，随机取50次字符，生成长度50的随机序列
	rand(string, 15, true) // 以string为模板，随机取15次互不相等的字符，生成长度15的随机序列
	rand(string, 15, true, true) // 以string为模板，随机取15次忽略大小写的互不相等的字符，生成长度15的新随机序列
	
###字符串增强
平时我们常常遇到字符串的拼接。拼接总是非常麻烦。而C#提供一种简单，可读性高的字符串拼接（生成）方式。这里引入：

用法：
	
	$("hello, my name is {0}, let's write java with {1}!").fill("cass","Style");

将会返回这样一条字符串：

	"hello, my name is cass, let's write java with Style!"
	
如果您将要生成的量封装成了对象，那么Style还提供这种方式：  
例如这么一个Sample类

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
	}
	
可以有

	var sample = new Sample("cass", 20, "male");
	System.out.println(
		$("My name is ${name}, I'm ${age} years old, and I'm ${sex}.")
			.from(sample));
			
将输出

	My name is cass, I'm 20 years old, and I'm male.

此外，字符串比较比较耗时。string提供了程序内唯一的字符串，比较时只需比较引用即可。

	$("abc")==$("abc")

将为true
	
##JSON
你可以通过“长得很像JSON”的Object数组创建一个JSONLike对象。  
比如说这样创建一个JSONLike对象

	map(new Object[]{
		"name"	, "cass",
		"age"	, 20,
		"sex"	, "male"
	});
>JSONLike 继承了 LinkedHashMap

##join
有时候我们希望对多个List中的元素进行排序，但不希望改变它们的长度，这时可以使用**join**

当你join List时, 一个代理List将被生成, 它不支持任何可能改变长度的方法. 而且，所有操作将直接在被代理list上进行.

	List<T> joinedList = join(list1, list2, list3, list4, ...);
	Collections.sort(joinedList);
	// list1, list2, list3, list4, ... will be modified.
	
##PathMapper
将对象以“路径”的格式进行存储。  
路径根据“.”分割。

实际上是用ConcurrentHashMap实现的，  
其中，真实存储的值对应的键为"$value"。

put:

	mapper.put("a.b.c", "i am a.b.c");

或者

	mapper.get("a.b", ()->"abc");
	
get:

	mapper.get("a.b.c");

用于存储的Map会变为
	
	{a={b={c={$value=i am a.b.c}, $value=abc}}}
			
#附录

##上次循环结果
For, For-to-step, While, forEach/forThose 循环 都有返回值  
当一个循环结束时，它也许会返回一个值给循环控制器。

循环控制器保存了一个叫做“上次循环结果”的值。  
控制器检查循环返回的结果

如果结果不是null, 它将以结果覆盖这个值. 如果是null，那么控制器将忽略这个结果，然后继续进行循环。
>循环控制器不是一个类，它是一个方法。更明确的说，是Style.For(i,c,inc,loop) 和 Style.While(c,loop). 它们是*Style*大部分循环的基础.