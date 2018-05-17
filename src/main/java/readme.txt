1、根据条件判断是否对对象进行装配
	1.1、Condition接口
	1.2、@Conditional注解
	1.3、@ConditionalOnProperties配合这个使用，将可以动态的接收参数
	二者进行配合使用即可，具体的可以参见如下包中的类：
		org.springframework.boot.autoconfigure.condition 包下的所有类，这才是主流的使用方式，
		很少有直接用@Conditional注解在我们需要的类上面，而是把@Conditional注解在另外一个注解A上
		面，然后再在这个注解A设置一些参数，那么注解在A上面的的注解的实现了conditional接口的实现类
		可以获取参数，然后按照一定的逻辑，进行判断是否注册bean
	
2、Springboot给我们提供了很多实现了Condition接口的实现类