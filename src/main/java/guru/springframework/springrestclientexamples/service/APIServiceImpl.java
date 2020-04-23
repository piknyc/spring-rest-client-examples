package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.User;
import guru.springframework.springrestclientexamples.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class APIServiceImpl implements  APIService{

	private final RestTemplate restTemplate;

	public APIServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit) {
		UserData userData = restTemplate.getForObject("http://private-anon-1df0e8173a-apifaketory.apiary-mock.com/api/user?limit=" + limit, UserData.class);
		return userData.getData();
	}
}
