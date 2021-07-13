package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

public class CustomerDAOImp implements CustomerDAO {
	private static AccountDAO accountDao = new AccountDAOImpl();

	@Override
	public List<Customer> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers";
			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<Customer> cList = new ArrayList<>();
			while (result.next()) {
				Customer customer = new Customer();
				customer.setId(result.getInt("id"));
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setUserName(result.getString("user_name"));
				customer.setPassword(result.getString("password"));
				customer.setCheckingBalance(result.getInt("account_balance"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));

				String accountName = result.getString("account");
				if (accountName != null) {
					Account account = accountDao.findAccount(accountName);
					customer.setAccount(account);
				}

				cList.add(customer);
			}
			return cList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM customers WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery(sql);
			Customer customer = new Customer();

			while (result.next()) {
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setPassword(result.getString("password"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
//				customer.setCurrentDate(result.getDate("account_created"));
				customer.setId(result.getInt("id"));
			}
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO customers(first_name, last_name, user_name, password, account_balance, active , registered)"
					+ " VALUES(?,?,?,?,?,?,?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;

			statement.setString(++index, customer.getFirstName());
			statement.setString(++index, customer.getLastName());
			statement.setString(++index, customer.getUserName());
			statement.setString(++index, customer.getPassWord());
			statement.setInt(++index, customer.getCheckingBalance());
			statement.setBoolean(++index, customer.getIsActive());
			statement.setBoolean(++index, customer.getRegistered());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int setId(String firstName) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT id FROM customers WHERE id = ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, firstName);

			ResultSet result = statement.executeQuery(sql);
			Customer customer = new Customer();

			while (result.next()) {
				customer.setFirstName(result.getString("first_name"));
				customer.setLastName(result.getString("last_name"));
				customer.setPassword(result.getString("password"));
				customer.setIsActive(result.getBoolean("active"));
				customer.setRegistered(result.getBoolean("registered"));
				customer.setDateCreated(result.getDate("account_created"));
				customer.setId(result.getInt("id"));
			}
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (Integer) null;

	}

	@Override
	public Customer findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(String firstName) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "DELETE FROM customers WHERE first_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
//			Statement statement = conn.createStatement();

			statement.setString(1, firstName);

//			return true;
//			Customer customer = new Customer();

//			while (result.next()) {
//				customer.setFirstName(result.getString("first_name"));
//				customer.setLastName(result.getString("last_name"));
//				customer.setPassword(result.getString("password"));
//				customer.setIsActive(result.getBoolean("active"));
//				customer.setRegistered(result.getBoolean("registered"));
//				customer.setCurrentDate(result.getDate("account_created"));
//				customer.setId(result.getInt("id"));
//			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public int deleteCustomerid(int id) {

		String SQL = "DELETE FROM customers WHERE id = ?";

		int affectedrows = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, id);

			affectedrows = pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedrows;
	}

	public int deleteCustomerbyName(String firstName) {

		String SQL = "DELETE FROM customers WHERE first_name = ?";

		int affectedrows = 0;

		try (Connection conn = ConnectionUtil.getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, firstName);

			affectedrows = pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedrows;
	}

}
