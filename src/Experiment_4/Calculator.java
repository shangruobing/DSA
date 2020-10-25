package Experiment_4;
import java.util.StringTokenizer;

public class Calculator {
	final private char Plus ='+';
	final private char Minus='-';
	final private char Mult ='*';
	final private char Div ='/';
	final private char LP ='(';
	final private char RP =')';
	private StackADT<Character> op_stack; //存操作符栈
	private StackADT<Double> num_stack; //存操作数栈
	private String Expression; //存放输入的表达式
	int state; //存放表达式计算的状态，0：未计算，1：计算正确，-1表达式错
	double Value=0;


	private void SimplCal(int op) throws EmptyCollectionException {
		//将操作数栈中弹出两个运算数进行op指定的运算，运算结果再压入栈中；
		double x1,x2;
		x2=num_stack.pop();
		x1=num_stack.pop();
		switch(op) {
			case Plus:
				num_stack.push(x1+x2);
				break;
			case Minus:
				num_stack.push(x1-x2);
				break;
			case Mult:
				num_stack.push(x1*x2);
				break;
			case Div:
				num_stack.push(x1/x2);
				break;
		}
	}

	private boolean isOperator(String token){
		//用于判断token是否为运算符；
		return (token.equals("+")||token.equals("-")||
				token.equals("*")||token.equals("/")||
				token.equals("(")||token.equals(")"));
	}

	private boolean P_NoSmall(char op1, char op2){
		//用于判断运算符op1的优先级是否不小于op2；
		if(((op1==Plus||op1==Minus)&&(op2==Plus||op2==Minus))|| //同为加减
			((op1==Mult||op1==Div)&&(op2==Mult||op2==Div))|| //同为乘除
			((op1==Mult||op1==Div)&&(op2==Plus||op2==Minus))) //op1比op2高
			return true;
		else
			return false;
	}

	private void process(){
		String token;
        char op;
		StringTokenizer tokenizer = new StringTokenizer(Expression);
		try {
			while (tokenizer.hasMoreElements()) { //返回是否还有分隔符
				token = tokenizer.nextToken();

				if (!isOperator(token)) {  //扫描到的token是运算数
					num_stack.push(Double.parseDouble(token));
					System.out.println("数据栈" + num_stack.peek());
				}

				if (isOperator(token)) {

					//运算栈不为空
					while (!op_stack.isEmpty() && P_NoSmall(op_stack.peek(), token.charAt(0)) == true) {
						op = op_stack.pop();
						System.out.println("运算栈内弹出" + op);

						SimplCal(op);
						System.out.println("计算结果 并压入数据栈" + num_stack);
					}
					op_stack.push(token.charAt(0));
					System.out.println("运算栈" + op_stack.peek());

					if (op_stack.isEmpty()) { //运算栈为空
						op_stack.push(token.charAt(0)); //当运算栈为空 将运算栈压入
						System.out.println("空运算栈" + op_stack.peek());
					}
				}

				if (token.charAt(0) == '(')
					op_stack.push(token.charAt(0));

				if (token.charAt(0) == ')') {
					while (op_stack.peek() != '(') {
						op_stack.pop();
						op = op_stack.pop();
						System.out.println("运算栈内弹出" + op);
						SimplCal(op);
						System.out.println("计算结果 并压入数据栈" + num_stack);
						op_stack.pop();
					}

					if (op_stack.peek() == '(')
						op_stack.pop();
				}
			}

			while (!op_stack.isEmpty()) {
				op = op_stack.pop();
				SimplCal(op);
				System.out.println("数据栈最终结果" + num_stack.peek());
				System.out.println("数据栈大小"+num_stack.size());
				System.out.println("操作栈大小"+op_stack.size());

			}

			if (num_stack.size() == 1) {
				Value = num_stack.pop();
			state++;
			}
		}
		catch (EmptyCollectionException e) {
			state=-1; // 表达式出错
		}
	}

	public Calculator(){
		op_stack = new ArrayStack<Character>();
		num_stack = new ArrayStack<Double>();
		state=0; //保存对象的状态 0表示未计算，1表示计算正确
	}

	public void SetExpression(String exp){ //设置要计算的表达式
		Expression=exp;
		state=0;
	}

	public int GetState(){ //获取计算状态
		return state;
	}

	public double GetExpValue(){ //获取表达式的计算值
		if (state==0)
			process(); //如未计算就计算
		if (state==1)
			return Value; //如计算正确就返回计算值
		else
			return 0;
	}
}