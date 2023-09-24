package pack.setterex;


// 이 MyProcessService 클래스의 생성자를 XML파일에 생성한다 (Spring 방식) 
public class MyProcessService {
	private int nai;
	private String name;
	private ShowData showData;
	
	public MyProcessService() { // 기본생성자는 생략이 가능하다 (기본생성자를 호출안했기 때문에 자동으로 자바에서 만들어준다)
		
	}
	
	// private 멤버 값은 외부에서 setter를 사용해 입력(setter injection)
	public void setNai(int nai) { 
		this.nai = nai;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	
	// 현재 nai, name, showData가 getter가 없기 때문에 현재 NULL값이기 때문에 XML파일에 가서 데이터를 줘야한다. 
	public void displayData() {
		System.out.println("이름은 " + name + ", 나이는 " + nai + 
							", 별명은" + showData.processHobby() +  
							", 취미는" + showData.processName());
	}
}
