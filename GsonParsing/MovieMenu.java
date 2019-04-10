import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MovieMenu {
	
	public static void main(String[] args) {
		MovieMenu menu = new MovieMenu();
		menu.process();
	}
	
	// Sub Classes
	public class Movie {
		private String title;
		private int year;
		private List<String> cast;
		private List<String> genres;
		public Movie() {
			this(null, -1, null, null);
		}
		public Movie(String name, int year, List<String> actors, List<String> genres) {
			this.title = name;
			this.year = year;
			this.cast= actors;
			this.genres = genres;
		}
		public String getName() {
			return title;
		}
		public void setName(String name) {
			title = name;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public List<String> getActors() {
			return cast;
		}
		public void setActors(List<String> actors) {
			cast = actors;
		}
		public List<String> getGenres() {
			return genres;
		}
		public void setGenres(List<String> genres) {
			this.genres = genres;
		}
	}
	public static class MovieUtil {
		private static List<Movie> movies;
		private MovieUtil() {
			try {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json = new String(Files.readAllBytes(Paths.get("src\\Movies.json")));
				movies = Arrays.asList(gson.fromJson(json, Movie[].class));
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		public static List<Movie> getMovies() {
			return movies;
		}
	}
	
	// Fields
	private final String optionsPrompt = "Type a single single-letter option:\n"	+ 
			"A) Look up an Actor/Actress\n" + 
			"B) Look up a Movie Title\n" + 
			"C) Look up a Year\n" + 
			"D) Add a new movie\n" + 
			"E) Degrees to Kevin Bacon\n";
	private Scanner in = new Scanner(System.in);
	
	
	
	private String askPrompt(String prompt) {
		System.out.println(prompt);
		String option = in.nextLine();
		return option;
	}
	private void process() {
		String option = askPrompt(optionsPrompt);
		switch (option.toUpperCase()) {
			case "A":
				String aName = askPrompt("Enter an actor/actress name.");
				lookUpPerson(aName);
				break;
			case "B":
				String title = askPrompt("Enter a movie title.");
				lookUpMovie(title);
				break;
			case "C":
				int year = Integer.parseInt(askPrompt("Enter a year."));
				lookUpYear(year);
				break;
			case "D":
				String dName = askPrompt("Enter a movie name.");
				int dYear = Integer.parseInt(askPrompt("Enter a year."));
				List<String> actors = Arrays.asList(askPrompt("Enter a list of actors separated by a comma (don't enter extra spaces).").split(","));
				List<String> genres = Arrays.asList(askPrompt("Enter a list of genres separated by a comma (don't enter extra spaces).").split(","));
				Movie movie = new Movie(dName, dYear, actors, genres);
				addMovie(movie);
				break;
			case "E":
				String eName = askPrompt("Enter an actor/actress name.");
				degreesToKevinBacon(eName);
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
		end();
	}
	
	private List<Movie> lookUpPerson(String name) {
		List<Movie> inMovies = new ArrayList<Movie>();
		for (Movie m : MovieUtil.getMovies()) {
			if (m.getActors().contains(name)) {
				inMovies.add(m);
			}
		}
		return inMovies;
	}
	private void lookUpMovie(String name) {
		
	}
	private void lookUpYear(int year) {
		
	}
	private void addMovie(Movie movie) {
		
	}
	private int degreesToKevinBacon(String name) {
		
		return -1;
	}
	private void end() {
		in.close();
		System.out.println("Goodbye.");
	}
}
