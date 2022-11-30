package in.ashokit.response;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.Covid19Details;

@Service
public class SyncResponseService 
{
	
	//Representing JSON RESPONSE in STRING
	public void getResponseInStrig()
	{
		WebClient webClient = WebClient.create();
		String url = "https://covid-19-data.p.rapidapi.com/country/code?code=IN";
		String body = webClient.get()
		.uri(url)
		.header("x-rapidapi-host","covid-19-data.p.rapidapi.com")
		.header("x-rapidapi-key", "d85da90036msh70114ef505ab3fap1dfdc8jsne4d243b0de10")
		.retrieve()
		.bodyToMono(String.class)
		.block();
		
		System.out.println(body);
	

	}
	
	
	//REPRESENTING JSON RESPONSE IN Object
	public void getResponseInObject()
	{
		WebClient webClient = WebClient.create();
		String url = "https://covid-19-data.p.rapidapi.com/country/code?code=IN";
		Covid19Details[] c19s = webClient.get()
				.uri(url)
				.header("x-rapidapi-host","covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "d85da90036msh70114ef505ab3fap1dfdc8jsne4d243b0de10")
				.retrieve()
				.bodyToMono(Covid19Details[].class)
				.block();
		
		/*for(Covid19Details c19 : c19s)
		{
			System.out.println(c19);
		}
		*/
		Stream.of(c19s).forEach(System.out::println);
		
       
	}

}
