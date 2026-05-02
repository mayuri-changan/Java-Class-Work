/*package com.demo.vehicle;
import java.util.Objects;
public class Vehicle
{
    protected int vehicleId;
    protected String vehicleName;
    protected double price;
    protected String status; 

    public Vehicle(int vehicleId, String vehicleName, double price, String status) 
    {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.price = price;
        this.status = status;
    }

    public int getVehicleId() 
    {
        return vehicleId;
    }

    public String getVehicleName() 
    {
        return vehicleName;
    }

    public double getPrice() 
    {
        return price;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(vehicleId);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) obj;
        return this.vehicleId == v.vehicleId;
    }

    @Override
    public String toString()
    {
        return "ID=" + vehicleId + ", Name=" + vehicleName +
               ", Price=" + price + ", Status=" + status;
    }
}*/
package com.demo.vehicle;
import java.util.Objects;
public class Vehicle{
	protected int vehicleId;
	protected String vehicleName;
	protected double price;
	protected String status;
	public Vehicle(int vehicleId,String vehicleName,double price,String status) {
		this.vehicleId=vehicleId;
		this.vehicleName=vehicleName;
		this.price=price;
		this.status=status;	
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public double getPrice() {
		return price;
	}
	public String getStatus() {
		return status;
	}
	public void setPrice(double price) {
		this.price=price;
		
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public int hashCode() {
		return Objects.hash(vehicleId);
	}
	public boolean equals(Object obj) 
	{
		if(this==obj)return true;
		if(!(obj instanceof Vehicle))return false;
		Vehicle v=(Vehicle)obj;	
		return this.vehicleId==v.vehicleId;
		
	}
	public String toString() {
		return vehicleId+vehicleName+price+status;
	}



	}


	
	














