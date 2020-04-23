package guru.springframework.springrestclientexamples.service;

import guru.springframework.springrestclientexamples.domain.User;
import guru.springframework.springrestclientexamples.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class APIServiceImpl implements APIService {

	private final RestTemplate restTemplate;
	private final String apiUrl;

	public APIServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String apiUrl) {
		this.restTemplate = restTemplate;
		this.apiUrl = apiUrl;
	}

	@Override
	public List<User> getUsers(Integer limit) {
		UriComponentsBuilder uriComponentsBuilder =
				  UriComponentsBuilder.fromUriString(apiUrl)
							 .queryParam("limit", limit);
		UserData userData = restTemplate
				  .getForObject(uriComponentsBuilder.toUriString(), UserData.class);
		return userData.getData();
	}
}
