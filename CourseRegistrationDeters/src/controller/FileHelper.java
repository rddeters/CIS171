package controller;
import java.util.ArrayList;
/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03 
*/

public interface FileHelper {
	public boolean doesAFileExist();
	public boolean writeFile(ArrayList<?> list);
	public ArrayList<?> readFile( );
}
