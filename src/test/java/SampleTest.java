import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataDriven d= new DataDriven();
	ArrayList<String> data=	d.getData("Add Profile");
	System.out.println(data);
	}

}
