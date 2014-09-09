package 简单的任务取消;

public class Test {
	int a1;
	static int a2;
	static class A
	{
		A()
		{
			a2=2;
			a1=2;
		}
		static void f()
		{
			a1=2;
		}
		
	}
	
	class B
	{
		B()
		{
			a1=2;
			a2=3;
		}
		
		static void f()
		{
			
		}
	}
	
	public static void main(String s[])
	{
		Test.A.f();
		Test.B tb = new Test().new B();
		Test.A a = new Test.A();
	}
}

