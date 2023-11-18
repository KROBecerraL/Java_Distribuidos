package lab5;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SongService {
    @WebMethod
    Response getSongsByGenre(String genre);
}