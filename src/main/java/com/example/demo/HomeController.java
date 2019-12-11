import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;
    @RequestMapping("/")
    public String loadData(){
        Actor a = new Actor();
        a.setName("Sandra Bullock");
        a.setRealname("Sandra Mae Bullowski");
        actorRepository.save(a);
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");
        movie.addActor(a);
        movieRepository.save(movie);
        return "redirect:/view";
    }
    @RequestMapping("/view")
    public String showData(Model model){
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
		