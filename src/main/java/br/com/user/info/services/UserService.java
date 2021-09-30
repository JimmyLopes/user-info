package br.com.user.info.services;

import br.com.shopping.cart.commons.shopping.cart.commons.exception.ServiceException;
import br.com.user.info.model.User;
import br.com.user.info.repository.UserRepository;
import org.springframework.stereotype.Service;

import static br.com.user.info.exception.ApplicationError.USI_USER_NOT_FOUND;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long userId) {
        return findUser(userId);
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ServiceException(USI_USER_NOT_FOUND));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
