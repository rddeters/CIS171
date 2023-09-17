package model;
/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 7th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class Classroom {
	private String building;
	private String roomNumber;
	private String campus;
	private String type;
	private int capacity;
	
	public Classroom() {
		setBuilding("1");
		setRoomNumber("100");
		setCampus("Ankeny");
		setType("Classroom");
		setCapacity(100);
	}
	
	public Classroom(String bld, String rmnum, String cps, String tp, int cap) {
		setBuilding(bld);
		setRoomNumber(rmnum);
		setCampus(cps);
		setType(tp);
		setCapacity(cap);
	}
	
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
    public String toString() {
        return "Classroom [building=" + building + ", roomNumber=" + roomNumber + ", campus=" + campus +
                ", type=" + type + ", capacity=" + capacity + "]";
    }
}
