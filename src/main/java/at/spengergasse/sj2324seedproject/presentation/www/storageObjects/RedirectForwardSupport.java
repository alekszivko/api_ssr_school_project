package at.spengergasse.sj2324seedproject.presentation.www.storageObjects;

public interface RedirectForwardSupport{

    default String redirect(String route){
        return "redirect:%s".formatted(route);
    }

    default String forward(String route){
        return "forward:%s".formatted(route);
    }
}
