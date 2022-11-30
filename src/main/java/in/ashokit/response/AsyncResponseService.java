package in.ashokit.response;

import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.binding.Covid19Details;
@Service
public class AsyncResponseService 
{
	//Representing JSON RESPONSE in STRING
public void getResponseInString()
{
	WebClient webClient = WebClient.create();
	String url = "https://covid-19-data.p.rapidapi.com/country/code?code=IN";
	               webClient.get()
	              .uri(url)
	              .header("x-rapidapi-host","covid-19-data.p.rapidapi.com")
	              .header("x-rapidapi-key", "d85da90036msh70114ef505ab3fap1dfdc8jsne4d243b0de10")
	              .retrieve()
	              .bodyToMono(String.class)
	              .subscribe(s->System.out.println(s));
	
	
}


//Representing JSON RESPONSE in object
public void getResponseInObject()
{
	WebClient webClient = WebClient.create();
	String url = "https://covid-19-data.p.rapidapi.com/country/code?code=IN";
	               webClient.get()
	              .uri(url)
	              .header("x-rapidapi-host","covid-19-data.p.rapidapi.com")
	              .header("x-rapidapi-key", "d85da90036msh70114ef505ab3fap1dfdc8jsne4d243b0de10")
	              .retrieve()
	              .bodyToMono(Covid19Details[].class)
	              .subscribe(c-> Stream.of(c).forEach(s->System.out.println(s)));
	

}



}
