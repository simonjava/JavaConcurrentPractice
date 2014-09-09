package 简单的任务取消;

public class Test2 {

	public void f()
	{
		class CC
		{
			int a;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BB b = new BB();
		b.f(2);
	}

}


class AA
{
	 final private void f()
	{System.out.println("A");}
	 final private void f(int a)
	{System.out.println("AA");}
}

class BB extends AA
{
	final void f()
	{System.out.println("B");}
	final void f(int a)
	{System.out.println("BB");}
}