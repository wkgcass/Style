#style工具集

* 简化java代码
* 使之更加易于编写和阅读
* 引入部分函数式编程的用法
* 引入其他语言优秀的编程方式
* 简化常用操作
* 减少可能出现的失误

任何问题均可Email我:wkgcass@hotmail.com  
在此感谢您使用Style工具集，喜欢的话点个星哦～

#版本
当前版本

	Version 0.1.1
主要更新：

* var接口。
* if表达式
* 字符串增强
* “隐式”类型转换
	
更新项目：

* 0.1.1 完全兼容 0.0.2
* 对于日期格式化，现在支持出现多次A或者a  
  （0.0.2只翻译第一个A或a）
* 新增接口var，在不能继承Style类的情况下，可以实现var接口以获得Style的全部功能。

		class YourClass implements var

	>但是由于java本身限制，使用实现var接口的方式仅对非static方法提供支持
	
	>var实际上是由调用Style类的许多default方法组成的接口
	
* 对于var的实现类，除了所有Style的方法外，额外提供了两个方法

		<T> T var.$();
		<T> T var.$(Class<T>)
	以便使用下述语法的情况下，在转换类型时更加方便：
	
		var x=new X();
* 在Async/Await中，对于异常的处理更新。现在您可以强制阻塞原线程直到执行完毕或异常抛出。

		aFoo.awaitError(err->{...});
* 对Array和Iteratable增加了一个功能，现在，在forEach和forThose中，您可以获取当前游标信息。这在集合＋数组操作中会非常有用。
		
		$(arr).forEach((e,i)->{
			i.currentIndex;	// int
			i.previousIndex;	// int
			i.nextIndex;		// int
			i.hasPrevious;	// boolean
			i.hasNext;		// boolean
			$(i) // 相当于i.currentIndex
		});

* Switch中增加了一个功能。现在您可以在Switch开头额外加入一个返回Boolean的两个同类型参数的函数。每次的Case比较将执行这个方法，若返回true则执行Case体。

	例如：
		
		Switch(i, (i,o)-> i+12 == o ).Case(1, ()->{...})
		// 当传入参数＋12后等于case块指定的常数时则执行Case体。
		
	>进入Case体后若Break出，则不会再次进入Case体。
* 新增带返回值的If表达式。详见文档
* 新增字符串增强。现在您可以更方便的格式化一条字符串。详见文档
* 新增“隐式”类型转换。详见文档
		
* 对于Store<T>，给出了一个别名，val\<T\>。
* 对于function<R>，给出了一个别名，def\<R\>。
	
	>实现上其实是让Store继承val，function继承def
	
*喜欢Scala的朋友使用这个版本会更亲切。*
	
历史版本

	Version 0.0.2 BUG修复
	Version 0.0.1

更新预告：	
下个版本将提供：

* 	带返回值的forEach/forThose/For/For-To-Step/While/Switch
*  针对反射进行简化和增强
	
#用法
更新至Version 0.1.1
##目录
* *起步*
* *函数式编程*
	* 接口
	* 创建
	* 工具
* 异步编程(async/await/callback)
	* Async
	* *Await*
	* Callback
	* 原生多线程简化
* 流程控制
	* break
	* continue
	* remove (iterator)
	* 其他
* 集合增强
	* 初始化
	* *forEach / forThose*
	* toSelf
	* Transform
	* 其他
* 基础语法增强
	* For
		* For-To-Step
	* While
	* *Switch*
	* *If*
* 异常处理
	* StyleRuntimeException
* 其他
	* Date
	* RegEx
	* Comparable
	* Rand
	* *字符串增强*
	* *“隐式”类型转化*
* 附录
	* $中的常用量 

##起步

使用style非常简单。

1. 引入*net.cassite.style.jar*
2. 新建一个类，推荐做法是，让这个类继承net.cassite.style.Style，例如：

		public class YourClass extends Style{
			public static void main(String[] args){
				$(args).forEach(s->System.out.println(s));
			}
		}
		
	如果由于种种原因不能继承，则可以实现(implements)*var*来使用该工具集。但是对于static方法无效。
	
		public class YourClass implements var{
			public static void main(String[] args){
				// 必须完整写出类名
				Style.$(args)
					.forEach(s->System.out.println(s));
			}
			public void main2(String[] args){
				// 不必写出类名
				$(args).forEach(s->System.out.println(s));
			}
		}
	
	如果由于种种原因不能继承或是必须使用static方法，则请通过*Style.静态方法*的方式使用该工具集。
	
		Style.$(args).forEach(s->System.out.println(s));

	>本文档后续均以*继承*方式为例进行叙述。
		
3. 在net.cassite.style包中有一个$类，里面预定义了许多常用量，例如：

		$(list).to(new ArrayList<>())
			.via($.copy()); // $.copy()表示将原集合内容复制到新集合中。

	更多详情请转到附录


##函数式编程

###接口
style提供了9个带返回值的接口，以及9个无返回值的接口。它们均类似于：

	@FunctionalInterface
	public interface R3ArgsInterface<R, T0, T1, T2> {
		R apply(T0 arg0, T1 arg1, T2 arg2) throws Throwable;
	}

为了方便函数式编程，分别预设了参数个数从0到7的接口，外加不定参数个数的接口。  
**命名方式**：

* 有返回值，以R开头
* 无返回值，以Void开头
* 接下是数字，表示参数个数
* 0个或1个参数，接下来为Arg
* 其他为Args
* 最后以Interface结尾
* 有返回值的第一个范型为返回值类型
* 后面每个均与参数一一对应
* 不定参数个数接口，参数类型为*Object...*

###创建

通过*function(interface)*或*$(interface)*来创建一个*function\<R\>*对象，代表一个函数，function对象也可写作def。  
例如：
	
	def<Integer> foo= function(
		(Integer i,function<Integer> func)
			-> i > 99 ? i : i + func.apply(i + 1, func)
	);
	
调用时使用*func.apply(...)*，例如：

	foo.apply(1,foo);
	
若输出结果，则会得到5050 *（从1加到100）*

>注意，由于java的特性，在初始化变量时不能引用该变量，否则会产生编译错误。  
>所以进行递归时需要额外传入一个function<T>类型参数
>
>巧妙的配合使用 $ 和 function 进行function对象的创建可以让代码更美观

###工具
由于java内部类调用外部变量时只允许访问final或有效的final，所以有的情况需要将原变量包装一下才可使用。这里提供工具Store\<T\>，也可以写成val\<T\>

	int age=20;
	val<Integer> _age=store(age);
	def<Object> grow=$(
		() -> $(_age) + 1
	);
	System.out.println(grow.apply()); // 输出21
	
>使用 _age.item 也可以直接访问被包装的对象

##异步编程

###Async
众所周知，async/await模型极大的简化异步编程的难度。  
在这里，我们继续使用上面求n到100和的函数作讲解

	Async<Integer> aFoo = foo.async(1,foo);
	
在Async创建时，异步调用已经开始。Async对象仅仅作为一个返回值的接收器使用。

###Await
Await用来取回异步执行函数返回值，有两种用法：

	aFoo.await();
	await(aFoo);
	
>若该异步操作尚未结束，则线程会阻塞直到操作完成为止。

此外，所有抛出的异常可以手动处理。[可选的]

	aFoo.onError((StyleRuntimeException err)->{...});
	
该异常处理也是非阻塞的  
实现方式为：若执行onError时有异常则直接处理，否则设置为“监听”，异常到来时在async线程上进行处理。  
还可以使用async.getErr()来获取可能的异常。

另外，你可以使用*.awaitError*来强制在原线程上处理异常。该方法会阻塞直到处理结束或者抛出异常。

	aFoo.awaitError((StyleRuntimeException err)->{...});

###Callback
回调也是一种异步模型，style也支持回调编程。  
回调需要向函数内传入一个callback，所以基本用法如下：

	// 定义一个函数
	function<Object> funcWithCallback = $(
		(Integer sum, Integer cursor, function<Object> func, function<Object> callback) -> {
			if (cursor > 99)
				callback.apply(sum + cursor);
			else
				func.apply(sum + cursor, cursor + 1, func, callback);
	});
	// 异步调用
	funcWithCallback.async(0, 1, funcWithCallback, 
		function((Integer sum) -> System.out.println(sum))
	);
	
最后输出结果5050

若有多个Async同时进行，并且需要一次性获取所有值，则可以用如下方式：
	
	function<Double> oneToTen = $(() -> {
		System.out.println(Thread.currentThread());
		double mul = 1;
		for (double i = 10; i >= 1; --i) {
			mul *= i;
		}
		return mul;
	});
	function<Double> elevenToTwenty = $(() -> {
		System.out.println(Thread.currentThread());
		double mul = 1;
		for (double i = 20; i >= 11; --i) {
			mul *= i;
		}
		return mul;
	});
	function<Double> twentyOneToThirty = $(() -> {
		System.out.println(Thread.currentThread());
		double mul = 1;
		for (double i = 30; i >= 21; --i) {
			mul *= i;
		}
		return mul;
	});
	function<Double> ThirtyOneToForty = $(() -> {
		System.out.println(Thread.currentThread());
		double mul = 1;
		for (double i = 40; i >= 31; --i) {
			mul *= i;
		}
		return mul;
	});

	$(oneToTen.async(), elevenToTwenty.async(), twentyOneToThirty.async(), ThirtyOneToForty.async())
			.callback(function((Double r1, Double r2, Double r3, Double r4) -> {
				System.out.println(r1 * r2 * r3 * r4);
	})).onError($.printHandler); // 异常处理[可选的]
	
此例中，分别异步执行1到10，11到20，21到30，31到40的乘法，最后统一乘起来（callback也是异步的）  
也就是计算 40! 结果为 8.159152832478977E47

>当然，你也可以使用*.callbackSync*方法同步执行callback函数。
>
>注意，此处callback参数与async返回值一一对应。
>
>由于计算简单，而且创建线程、访问内部类均有开销，所以本例中效率低于单线程计算，实际效率以环境而定。

###原生多线程简化
创建线程通常至少需要*new Thread(()->{do something...}).start();*

style工具集帮助你更简单的创建线程：

	Thread t = run(()->{do something...});

不需要手动调用*.start()*方法，style已经帮你进行了。所以，大部分情况下*Thread t*并不需要，获取只是为了更好的管理线程。

此外，我们有时需要线程，却并不需要过多的中断判断。  
所以这里提供一个方法。现在你只需要简单的调用*sleep(1000);*即可暂停1秒。

##流程控制

在下述文档中，您将会看到许多简化或另类方式给出的循环流程。  
在style工具集中，控制以异常抛出的形式进行。为了使代码美观，这里提供封装好的方法而不必手写throw new ...
###break

	Break(); // 用于跳出循环
	// 也可以这样使用
	throw new Break();
	
###continue

	Continue(); // 用于跳转到下一循环周期
	// 也可以这样使用
	throw new Continue();
	
###remove
仅在可迭代对象的部分方法中提供，详细见javadoc。

	Remove(); // 移除当前游标所在位置元素
	// 也可以这样使用
	throw new Remvoe();
	
通常您可以直接使用return来跳转到下一循环。
	
###其他
还专门对List（由于有ListIterator）提供几个控制方法

	Set，Add，Previous
	
但是请慎重使用，它们常常使得代码看起来很奇怪。

##集合增强

对于数组、可迭代对象、Collection、List、Map均进行了对应的增强。
###初始化
对于数组，可以使用原生的new Type[]{elements...}进行初始化。  
而对于Collection， Map，初始化略显麻烦。style为此进行了增强。

Collection初始化
>$(new ArrayList<String>, elem0, elem1, elem2,...);

Map初始化
>$(new HashMap<String,Integer>, $("str",123).$("str2",234)....);

初始化用法示例

	List<String> list = $(new ArrayList<String>(), 
		"winds", "sgslx", "beiKe"
	);
	
	Map<String, Integer> map = $(new HashMap<String, Integer>(), 
		 $("cass", 1995)
		.$("john", 1994)
		.$("cassie", 1996)
	);
	
实际上，该方式也可以用于向已有的集合中add/put元素。

###forEach / forThose
对于数组、可迭代对象、Map，均拥有forEach,forThose增强

对于数组、可迭代对象：
>$(a).forEach(e->{do something...});
>
>$(a).forThose(e->{when true...}, e->{do something...});

此外，还支持获取当前迭代游标位置，在数组处理时非常方便：
	
	$(a).forEach((e, i)->{
		i.currentIndex;	// int
		i.previousIndex;	// int
		i.nextIndex;		// int
		i.hasPrevious;	// boolean
		i.hasNext;		// boolean
		$(i) // 相当于i.currentIndex
	});

对于Map
>$(map).forEach((k,v)->{do something...});
>
>$(map).forThose((k,v)->{when true...}, (k,v)->{do something});

forEach用法示例：

	String[] names=new String[]{
		"winds", "sgslx", "beiKe"
	};
	
	$(names).forEach(name->System.out.println(name));

输出
  
	winds  
	sgslx  
	beiKe  

forThose用法示例：

	$(names).forThose(
		name->name.contains("i"), // 条件
		name->System.out.println(name)); // 执行

输出  

	winds  
	beiKe  
	
###toSelf
对于数组、可迭代对象，有toSelf增强

>$(a).toSelf(e->{do something... return replacement;});

toSelf示例：
	
	$(names).toSelf(e -> e + " changed.");
	
元素值将变为 winds changed.， sgslx changed.， beiKe changed.

###Transform
transform用于将数组、可迭代对象、Map转化为Collection（Map的transform可转化为Collection或Map）

用法：
>数组或可迭代对象：
>>$(toTrans).to(newCollection).via(e->{return newElement});
>
>Map：
>>$(map).to(newCollection).via((k,v)->{return newElement});  
>>$(map).to(newMap).via((k,v)->{return new Entry<K,V>(newKey,newValue)});

transform示例：

	List<String> mapToList = $(map)
		.to(new ArrayList<String>())
		.via((k, v) -> "key is " + k + " value is " + v);

由此获得的List中元素分别为：

	key is cass value is 1995
	key is cassie value is 1996
	key is john value is 1994

###其他
对于可迭代对象，提供*.first()*方法，用于获取聚合类中第一个元素。

	$(iterable).first();

对于Collection，提供*.add(Element)*方法，此方法为链式，用于连续的增加元素。

	$(coll).add(e1).add(e2).add(e3)....;
	
对于Map，提供*.append(K,V)*方法，此方法为链式，用于连续的put键值对。

	$(map).append(k1,v1).append(k2,v2)....;

在C#中，Dictionary可以通过*map[k]*来获取值。这里进行了类似的增强：

	V value = $(map).$(key);

##基础语法增强

###For
提供一种较为特殊的for，但语义和标准for相同，规则如下：
	
	For(T i, 
		Predicate<T> condition, 
		UnaryOperator<T> increment, 
		function loop) // void, 1 arg type T

首先以i为初始化，接着，对于每次循环，都要求condition返回true，每次循环末尾执行increment，并赋值给i。

例如

	For(0, (i) -> i < 10, (i) -> i + 1, (i) -> System.out.println(i));

执行效果等于
	
	for(int i=0;i<10;++i){
		System.out.println(i);
	}

这种形式的For在条件表达式更加复杂情况下更有可读性。

*For-To-Step*

在Basic中，有一种for语句类似这样：
	
	For i = 1 To 11 Step 2
		...
	End For
	
等价于

	for(int i=1;i<=11;i+=2){...}
	
在很多确定始末的情形下这种for非常容易理解。  
这里提供相似的写法：

	For(1).to(11).step(2).loop(i -> System.out.println(i));
	
其中step可省略。

为了方便各种情况书写，这里还提供等价于For-to-step的，以from开头的语句。

	from(1).to(11).step(2).loop(i -> System.out.println(i));

在某些情形下，这样的写法更加美观。

###While

	While(BooleanSupplier condition, function loop)
	
在使用迭代器时常常使用while，但这种写法在条件较为复杂的情形更加具有可读性。

###Switch

在java中，switch语句只支持少部分基本数字类型和String类型。  
在这里将Switch扩展到任何类型。

用法：

	Switch(toSwitch)
		.Case(c1, ()->{...})
		.Case(c2, ()->{...})
		...
		.Default(()->{...});

语法规则与标准switch一致。任意一处case体均可通过*Break();*跳出。

在Switch(...)中，可以指定一个函数作为Case块的进入依据。

例如：

	Switch(i, (i,o)-> i+12 == o ).Case(1, ()->{...})
	
>该函数要求返回Boolean，参数个数两个，且类型相同。

###If
通常我们使用if时会额外附带许多变量。实际上使用“带返回值的IF”可以改善这种现象。

用法：
	
	<T> T If(expression, def<T>)
	// 或 If(expression, T)
	.ElseIf(expression, def<T>)
	// 或 .ElseIf(expression, T)
	.Else(def<T>)
	// 或 .Else(T)
	// 或 .End()
	
例如：
	
	Integer year = 
	If(map.containsKey("john"), 
		() -> map.get("john"))
	.ElseIf(map.containsKey("cass"), 
		() -> map.get("cass"))
	.End();
	
>其中，如果所有的if(表达式)均为false，则：若表达式以End结尾，返回null。若以Else(def<T>)结尾，执行末尾的函数。若以Else(T)结尾，直接返回这个值。

##异常处理

###StyleRuntimeException
我们时常将一个Throwable包装成RuntimeException并抛出以减少try-catch。而重复代码量略多。  
所以style工具集提供了更简单的包装方式：

创建StyleRuntimeException非常简单：

	$(throwable)；
	
>如果(throwable instanceof StyleRuntimeException)为true，则直接返回该throwable

方法

* throwIn(Class<?>...) 当未包装对象在指定异常类型之中时抛出自身
* throwNotIn(Class<?>...) 当未包装对象不在指定异常类型之中时抛出自身
* origin() 获取原始未包装时的异常对象
* @Override getCause() 获取未包装异常对象的cause。若未包装异常对象是InvocationTargetException，则返回.getTargetException()

##其他

###Date
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

###RegEx
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

		public static Sample from(String str) {
			String[] strArr = str.split(";");
			return new Sample(strArr[0], Integer.parseInt(strArr[1]), strArr[2]);
		}
	}
	
可以有

	var sample = new Sample("cass", 20, "male");
	System.out.println(
		$("My name is ${name}, I'm ${age} years old, and I'm ${sex}.")
			.from(sample));

###“隐式”类型转化

这里的“隐式”其实依然是需要明确写出转化的，但转化过程封装在类中，不会在代码逻辑中占用太多篇幅。

用法：
	
	T imp(Object o, Class<T> cls)
	
将对象o转化为T类型。

转化依据将在对象o类型的类中寻找，也会在T类型的类中寻找。  
其中： 
被转化的对象若包含方法*T toT()*
>比如String toString() ,Integer toInteger()等

，则调用之，返回对应结果。

否则检查T类。为描述方便，此处规定o为U类的实例。  
若U中包含方法*static T from(U u)*则调用之，返回对应结果

以上面提到的Sample为例：

	imp(sample, String.class) 
	//将调用Sample的toString方法，把Sample转换为String类型。
	
	imp("cassie;19;female", Sample.class).name()
	//将调用Sample的static Sample from(String str)方法，
	//把String转换为Sample类型。
	//再调用.name()方法返回“姓名”
	
使用这种方式进行转化可以让代码逻辑更加清晰，隐藏转化的细节到类中，从而提高代码可读性。

##附录

###推荐用法
文档查找速度一定慢于IDE自动补全。  
所以推荐的使用方式是

1. 浏览文档，了解提供的大致功能。
2. 开启IDE自动补全，并且观察可用函数。
3. 选择合适的函数进行编程。

###net.cassite.style.$
rand相关

	fromAll : String
	fromHex : String
	fromKeyboard : String
	fromLowerCases : String
	fromNumbers : String
	fromRecognizable : String
	fromUpperCases : String
	
async/callback相关

	printHandler : Void1ArgInterface<StyleRuntimeException>
	printHandlerFunc : function<Object>
	throwHandler : Void1ArgInterface<StyleRuntimeException>
	throwHandlerFunc : function<Object>

集合相关

	alwaysTrue()
	copy()
	copyFunc()
	entries()
	entriesFunc()
	keyFunc()
	keys()
	mapCopy()
	mapCopyFunc()
	trim()
	trimFunc()
	values()
	valuesFunc()
	
Switch相关
	
	eql()
	eqlFunc : function<Boolean>

日期相关

	today()
	tomorrow()
	yesterday()
