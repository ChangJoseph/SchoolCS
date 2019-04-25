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
		while(!menu.getQuit()) {
			menu.process();
		}
		menu.end();
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
		public String toString() {
			return title+" "+year+" "+cast+" "+genres;
		}
	}
	public static class MovieUtil {
		private static List<Movie> movies;
		public static void initializeList() {
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
			if (movies == null) initializeList();
			return movies;
		}
		public static void setMovies(List<Movie> pMovies) {
			movies = pMovies;
		}
	}
	
	// Fields
	private final String optionsPrompt = "Type a single single-letter option:\n"	+ 
			"A) Look up an Actor/Actress\n" + 
			"B) Look up a Movie Title\n" + 
			"C) Look up a Year\n" + 
			"D) Add a new movie\n" + 
			"E) Degrees to Kevin Bacon\n" +
			"Q) Quit Program";
	private Scanner in = new Scanner(System.in);
	private boolean quit = false;
	
	
	
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
				System.out.println(lookUpPerson(aName));
				break;
			case "B":
				String title = askPrompt("Enter a movie title.");
				System.out.println(lookUpMovie(title));
				break;
			case "C":
				String yearStr = askPrompt("Enter a year.");
				yearStr = yearStr.replaceAll("[^\\d]","");
				if (yearStr.equals("")) {
					System.out.println("Invalid input.");
					break;
				}
				int year = Integer.parseInt(yearStr);
				System.out.println(lookUpYear(year));
				break;
			case "D":
				String dName = askPrompt("Enter a movie name.");
				int dYear = Integer.parseInt(askPrompt("Enter a year."));
				List<String> actors = Arrays.asList(askPrompt("Enter a list of actors separated by a comma (don't enter extra spaces).").split(","));
				List<String> genres = Arrays.asList(askPrompt("Enter a list of genres separated by a comma (don't enter extra spaces).").split(","));
				Movie movie = new Movie(dName, dYear, actors, genres);
				addMovie(movie);
				System.out.println(movie);
				break;
			case "E":
				String eName = askPrompt("Enter an actor/actress name.");
				degreesToKevinBacon(eName);
				break;
			case "Q":
				quit = true;
				System.out.println("Goodbye.");
				break;
			default:
				System.out.println("Invalid option.");
				break;
		}
		System.out.println();
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
	private List<Movie> lookUpMovie(String name) {
		List<Movie> inMovies = new ArrayList<Movie>();
		for (Movie m : MovieUtil.getMovies()) {
			if (m.getName().equals(name)) {
				inMovies.add(m);
			}
		}
		return inMovies;
	}
	private int lookUpYear(int year) {
		int count = 0;
		for (Movie m : MovieUtil.getMovies()) {
			if (m.getYear()==year) {
				count++;
			}
		}
		return count;
	}
	private void addMovie(Movie movie) {
		List<Movie> movies = new ArrayList<Movie>(MovieUtil.getMovies());
		movies.add(movie);
		MovieUtil.setMovies(movies);
		
	}
	private int degreesToKevinBacon(String name) {
		
		return 42;
	}
	private void end() {
		in.close();
	}
	public boolean getQuit() {
		return quit;
	}
}
