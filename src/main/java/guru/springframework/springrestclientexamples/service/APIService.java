package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.User;

import java.util.List;

public interface APIService {

	public List<User> getUsers(Integer limit);
}
