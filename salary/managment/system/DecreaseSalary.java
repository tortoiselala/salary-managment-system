/**
 * 
 */
package salary.managment.system;

/**
 * @author Tortoise
 *
 */
public class DecreaseSalary extends BaseSalary {

	// sickDeduction 病事扣款
	private double sickFee;
	// childCareFee 托儿费
	private double childCareFee;
	// rent 房租
	private double rentFee;
	// waterElectricityFee 水电
	private double waterElectricityFee;
	// otherFee 其他扣款
	private double otherFee;

	/**
	 * @throws Exception
	 * 
	 */
	public DecreaseSalary(String id, String name, sexEnum sex, short age, double baseSalary, String category)
			throws Exception {
		super(id, name, sex, age, baseSalary, category);
		setSickFee(0);
		setChildCareFee(0);
		setRentFee(0);
		setWaterElectricityFee(0);
		setOtherFee(0);

	}

	public DecreaseSalary(String id, String name, sexEnum sex, short age, double baseSalary, String category,
			double sickFee, double childCareFee, double rentFee, double waterElectricityFee, double otherFee)
			throws Exception {
		super(id, name, sex, age, baseSalary, category);
		setSickFee(sickFee);
		setChildCareFee(childCareFee);
		setRentFee(rentFee);
		setWaterElectricityFee(waterElectricityFee);
		setOtherFee(otherFee);
	}

	/**
	 * @return the sickFee
	 */
	public double getSickFee() {
		return sickFee;
	}

	/**
	 * @param sickFee the sickFee to set
	 * @throws Exception
	 */
	public void setSickFee(double sickFee) throws Exception {
		if (sickFee < 0) {
			throw new Exception("Illegal num!");
		}
		this.sickFee = sickFee;
	}

	/**
	 * @return the childCareFee
	 */
	public double getChildCareFee() {
		return childCareFee;
	}

	/**
	 * @param childCareFee the childCareFee to set
	 * @throws Exception
	 */
	public void setChildCareFee(double childCareFee) throws Exception {
		if (childCareFee < 0) {
			throw new Exception("Illegal num!");
		}
		this.childCareFee = childCareFee;
	}

	/**
	 * @return the rentFee
	 */
	public double getRentFee() {
		return rentFee;
	}

	/**
	 * @param rentFee the rentFee to set
	 * @throws Exception
	 */
	public void setRentFee(double rentFee) throws Exception {
		if (rentFee < 0) {
			throw new Exception("Illegal num!");
		}
		this.rentFee = rentFee;
	}

	/**
	 * @return the waterElectricityFee
	 */
	public double getWaterElectricityFee() {
		return waterElectricityFee;
	}

	/**
	 * @param waterElectricityFee the waterElectricityFee to set
	 * @throws Exception
	 */
	public void setWaterElectricityFee(double waterElectricityFee) throws Exception {
		if (waterElectricityFee < 0) {
			throw new Exception("Illegal num!");
		}
		this.waterElectricityFee = waterElectricityFee;
	}

	/**
	 * @return the otherFee
	 */
	public double getOtherFee() {
		return otherFee;
	}

	/**
	 * @param otherFee the otherFee to set
	 * @throws Exception
	 */
	public void setOtherFee(double otherFee) throws Exception {
		if (otherFee < 0) {
			throw new Exception("Illegal num!");
		}
		this.otherFee = otherFee;
	}

}
