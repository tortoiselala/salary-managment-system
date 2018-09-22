/**
 * 
 */
package salary.managment.system;

/**
 * @author Tortoise
 *
 */
public class IncreaseSalary extends BaseSalary {

	private double bonus; // 员工本月奖金
	private double allowance; // 员工本月补贴
	private double overtimePay;// 加班工资
	private double other;// 其他补贴

	/**
	 * @param id
	 * @throws Exception
	 */

	public IncreaseSalary(String id, String name, sexEnum sex, short age, double baseSalary, String category)
			throws Exception {
		super(id, name, sex, age, baseSalary, category);
		setBonus(0);
		setAllowance(0);
		setOvertimePay(0);
		setOther(0);
	}

	public IncreaseSalary(String id, String name, sexEnum sex, short age, double baseSalary, String category,
			double bonus, double allowance, double overtimePay, double other) throws Exception {
		super(id, name, sex, age, baseSalary, category);
		setBonus(bonus);
		setAllowance(allowance);
		setOvertimePay(overtimePay);
		setOther(other);
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 * @throws Exception
	 */
	public void setBonus(double bonus) throws Exception {
		if (bonus < 0) {
			throw new Exception("Illegal num!");
		}
		this.bonus = bonus;
	}

	/**
	 * @return the allowance
	 */
	public double getAllowance() {
		return allowance;
	}

	/**
	 * @param allowance the allowance to set
	 * @throws Exception
	 */
	public void setAllowance(double allowance) throws Exception {
		if (allowance < 0) {
			throw new Exception("Illegal num!");
		}
		this.allowance = allowance;
	}

	/**
	 * @return the overtimePay
	 */
	public double getOvertimePay() {
		return overtimePay;
	}

	/**
	 * @param overtimePay the overtimePay to set
	 * @throws Exception
	 */
	public void setOvertimePay(double overtimePay) throws Exception {
		if (overtimePay < 0) {
			throw new Exception("Illegal num!");
		}
		this.overtimePay = overtimePay;
	}

	/**
	 * @return the other
	 */
	public double getOther() {
		return other;
	}

	/**
	 * @param other the other to set
	 * @throws Exception
	 */
	public void setOther(double other) throws Exception {
		if (other < 0) {
			throw new Exception("Illegal num!");
		}
		this.other = other;
	}

}
