package salary.managment.system;

public class BaseSalary {
	public static enum sexEnum {
		man, woman
	};

	public final static boolean man = true;
	public final static boolean women = false;

	private String id;
	private String name;
	private sexEnum sex;
	private short age;
	private double baseSalary;
	private String category;

	public BaseSalary(String id) throws Exception {
		setId(id);
		setName("");
		setSex(sexEnum.man);
		setAge((short) 0);
		setBaseSalary(0);
		setCategory("");
	}

	/**
	 * 
	 * @param id         员工的唯一标识信息，身份证号 位数要求：18位数字 最后一位可以为字母X
	 * @param name       员工名称 要求不可超过5个字符
	 * @param sex        员工性别
	 * @param age        员工年龄
	 * @param baseSalary 员工基础工资
	 * @param category   员工类别
	 * @throws Exception 员工身份证号输入错误时抛出异常
	 */
	public BaseSalary(String id, String name, sexEnum sex, short age, double baseSalary, String category)
			throws Exception {
		setId(id);
		setName(name);
		setSex(sex);
		setAge(age);
		setBaseSalary(baseSalary);
		setCategory(category);
	}

	/**
	 * @return the iD
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param iD the iD to set
	 * @throws Exception
	 */
	public void setId(String id) throws Exception {
		char[] idToCharArray = id.toCharArray();
		int idLength = idToCharArray.length;
		if (idLength != 18) {
			throw new Exception("Incorrencted length of ID!");
		}
		for (int i = 0; i < idLength - 1; i++) {
			if (idToCharArray[i] < '0' || idToCharArray[i] > '9') {
				throw new Exception("Incorrect format of ID");
			}
		}
		char idLastChar = idToCharArray[idLength - 1];
		if (idLastChar > '9' && idLastChar < '0' && idLastChar != 'x' && idLastChar != 'X') {
			throw new Exception("Incorrect format of ID");
		}
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 * @throws Exception
	 */
	public void setName(String name) throws Exception {
		if (name.length() >= 5) {
			throw new Exception("Too long name length!");
		}
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public sexEnum getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(sexEnum sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public short getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 * @throws Exception
	 */
	public void setAge(short age) throws Exception {
		if (age <= 0 || age >= 150) {
			throw new Exception("Illegal age num!");
		}
		this.age = age;
	}

	/**
	 * @return the baseSalary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}

	/**
	 * @param baseSalary the baseSalary to set
	 * @throws Exception
	 */
	public void setBaseSalary(double baseSalary) throws Exception {
		if (baseSalary < 0) {
			throw new Exception("Illegal base salary num!");
		}
		this.baseSalary = baseSalary;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

}
