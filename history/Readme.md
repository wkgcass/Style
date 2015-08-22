#Welcome to Project *Style*

*Style* helps you write java code in an effective and pretty way.

##For example
Usually we write:
	
	// 1
	Set<String> strings......
	for(String str : strings){
		System.out.println(str);
	}
	String[] strArr=new String[strings.length];
	int i=0;
	for(String str : strings){
		strArr[i] = str;
		++i;
	}
	
	// 2
	List<Integer> intList = new ArrayList<Integer>();
	intList.add(1);
	intList.add(2);
	...
	Map<String, Integer> nameToAge=new HashMap<String, Integer>();
	nameToAge.put("cass", 20);
	nameToAge.put("john", 21);
	
	// 3
	List<Integer> ages=new ArrayList<Integer>();
	for(Integer i : nameToAge.values()){
		ages.add(i);
	}
	
	// 4
	User user=new User(...);
	String sql="SELECT id FROM users WHERE age='" 
		+ user.getAge() + "' AND name='" 
		+ user.getName() + "' AND sex='" 
		+ user.getSex() + "';";

	// 5
	if(user.equals(user2)){
		...stmt0...
	}else if(user.equals(user3)){
		...stmt1...
	}else{
		...stmt2...
	}
	
	// 6
	...
	There're many things to do if you need Async/Await.
	
##With *Style*
	
	// 1
	Set<String> strings......
	$(strings).forEach(str->System.out.println(str));
	
	String[] strArr=new String[strings.length];
	$(strings).forEach((str, i)->{		// since 0.1.1
		strArr[$(i)]=str;
	});
	
	// 2
	List<Integer> intList = $(new ArrayList<Integer>(),
		1,2,3,4);
	Map<String, Integer> nameToAge=$(new HashMap<String, Integer>()
	, $("cass", 20).$("john", 21));
	
	// 3
	List<Integer> ages=$(nameToAge)
		.to(new ArrayList<Integer>())
		.via( (k,v) -> v );
		
	// 4
	User user=new User(...);
	String sql=$("SELECT id FROM users WHERE age='${age}', name='${name}', sex='${sex}';")
		.from(user);
		
	// 5
	Switch(user)
		.Case(user2, ()->{
			...stmt0...
			Break();
		})
		.Case(user3, ()->{
			...stmt1...
			Break();
		})
		.Default(()->{
			...stmt2...
		});
	
	// 6
	def<Integer> calculate=function(()->{
		int sum = 0;
		for(int i=1;i<=10000;++i){
			sum += i;
		}
		return sum;
	});
	Async<Integer> a = calculate.async();
	......
	Integer res = a.await();

You can find detailed API tutorial in *version* directory.

Feel free to contact me through e-mail: wkgcass@hotmail.com.