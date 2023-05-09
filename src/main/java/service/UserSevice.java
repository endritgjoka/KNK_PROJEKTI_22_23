package service;

import models.Perdoruesi;
import repository.UserRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class UserSevice {
    private UserRepository userRepository;

    // public UserSevice() {
    // this.userRepository = new UserRepository();
    // }

    public static Perdoruesi login(String username, String password) throws SQLException {
        Perdoruesi loginUser = UserRepository.getByUsername(username);

        if (loginUser == null) {
            // throw new SQLException("Username not found!");
            return null;
        }

        boolean isPasswordCorrect = PasswordHasher.compareSaltedHash(password, loginUser.getSalt(),
                loginUser.getFjalekalimi_salted());

        if (isPasswordCorrect) {
            return loginUser;
        }

        return null;
    }

    public static Perdoruesi signUp(String emri, String mbiemri, String username, String fjalekalimi,
                                    char gjinia, boolean admin, Date ditelindja) throws SQLException {
        String salted = PasswordHasher.generateSalt();
        String fjalekalimi_salted = PasswordHasher.generateSaltedHash(fjalekalimi, salted);
        Perdoruesi perdoruesi = new Perdoruesi(0, emri, mbiemri, username, fjalekalimi_salted,
                salted, gjinia, admin,ditelindja);
        UserRepository.insert(perdoruesi);

        return UserRepository.getByUsername(username);

    }

    // public static List<User> filterUsers(UserFilter filter, Pagination
    // pagination){
    // try {
    // return UserRepository.getByFilter(filter, pagination);
    // }catch(SQLException e){
    // return null;
    // }
    // }
}