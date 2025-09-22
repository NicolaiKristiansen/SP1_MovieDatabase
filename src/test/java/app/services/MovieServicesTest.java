package app.services;

import app.dtos.MovieResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MovieServicesTest {
    ApiServices apiServices = new ApiServices();
    String token = System.getenv("token");

    @Test
    void getMoviesFromAPI() throws JsonProcessingException {
        String token = System.getenv("token");
        String uri = "https://api.themoviedb.org/3/discover/movie?language=da&page="+1+"&region=DK&sort_by=popularity.desc&with_original_language=da&primary_release_date.gte=2020-09-15";
        MovieResponseDTO answer = apiServices.fetchData(token, uri, MovieResponseDTO.class);
        String json = "{\n" +
                "  \"page\": 1,\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xJ4rwDPcVzqSTxGftOBqYUehSbm.jpg\",\n" +
                "      \"genre_ids\": [99, 10402],\n" +
                "      \"id\": 1426672,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Christopher - A Beautiful Real Life\",\n" +
                "      \"overview\": \"Popikonet Christopher står på tærsklen til verdensberømmelse, men da hans andet barn melder sin ankomst, udfordrer det hans prioriteter. Er drømmen prisen værd?\",\n" +
                "      \"popularity\": 11.5297,\n" +
                "      \"poster_path\": \"/vZalS5PKYA5ZA5Z3Hw0Gxw2U1nw.jpg\",\n" +
                "      \"release_date\": \"2025-08-26\",\n" +
                "      \"title\": \"Christopher - A Beautiful Real Life\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"vote_count\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xPPBElHCcNQ7H3aXdLptykKxyZ1.jpg\",\n" +
                "      \"genre_ids\": [18, 36],\n" +
                "      \"id\": 1232827,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Pigen med nålen\",\n" +
                "      \"overview\": \"Karoline, en ung fabriksarbejder, bliver forladt og gravid, mens hun kæmper for at komme ud af fattigdommen i København efter 1. verdenskrig. Midt i sin kamp møder hun Dagmar, en karismatisk kvinde, der driver et skjult adoptionsbureau i en slikbutik, hvor hun hjælper fattige mødre med at finde plejefamilier til deres uønskede børn. For at undslippe fattigdommen påtager Karoline sig rollen som amme.\",\n" +
                "      \"popularity\": 8.5904,\n" +
                "      \"poster_path\": \"/w5XAp3Gcf5QdWkRwfiJ0gb90Gpu.jpg\",\n" +
                "      \"release_date\": \"2025-01-23\",\n" +
                "      \"title\": \"Pigen med nålen\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.604,\n" +
                "      \"vote_count\": 270\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/pUaRgy7grfehKq5dWLSfk1yy02p.jpg\",\n" +
                "      \"genre_ids\": [53, 28],\n" +
                "      \"id\": 1085218,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Underverden 2\",\n" +
                "      \"overview\": \"Fortsættelse af actionthrilleren Underverden fra 2017. For syv år siden gik Zaid i krig mod København underverden for at hævne sin bror. Mens han sidder i fængsel, bliver han opsøgt af en PET-agent, som tilbyder ham at blive løsladt, hvis han til gengæld infiltrerer byens bandemiljø. Zaid får nu chancen for at redde sit familieliv, men hvad er prisen?\",\n" +
                "      \"popularity\": 4.1378,\n" +
                "      \"poster_path\": \"/A8EPXv3SV9qiNCIttIM4ezJRmhW.jpg\",\n" +
                "      \"release_date\": \"2023-04-13\",\n" +
                "      \"title\": \"Underverden 2\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.421,\n" +
                "      \"vote_count\": 579\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/vaHZNxg4hspIxVzT7Wl7VLwnWhX.jpg\",\n" +
                "      \"genre_ids\": [18, 35],\n" +
                "      \"id\": 1082462,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Camino\",\n" +
                "      \"overview\": \"Regitze er i begyndelsen af 30'erne. Hun har ikke noget arbejde, ingen kæreste og ingen børn. Hun er ordblind og opvokset i et akademisk hjem, men har aldrig følt sig helt accepteret, som den hun er. Da hendes mor dør, befinder Regitze sig et ret eksistentielt sted i sit liv. Hun er blevet gravid, og samtidig kæmper hun med forholdet til sin far, som hun i en længere periode ikke har haft kontakt til. Forholdet mellem far og datter bliver for alvor sat på spidsen, da de opdager, at morens sidste ønske indebærer, at Regitze og hendes far skal gå Caminoen sammen - en fælles pilgrimsvandring i Spanien, som måske kan forbinde parterne på ny. For at ære morens sidste ønske, beslutter de sig for at snøre skoene, men de 260 kilometer fra Astorga til Compostela kommer nu mere til at handle om de levende end de døde.\",\n" +
                "      \"popularity\": 5.1448,\n" +
                "      \"poster_path\": \"/iPvyM9S9XA6l1Wd6J4AkcC4O5aa.jpg\",\n" +
                "      \"release_date\": \"2023-04-05\",\n" +
                "      \"title\": \"Camino\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 4.8,\n" +
                "      \"vote_count\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/t90KM83WYtsAt8S4zdorFV7w5qV.jpg\",\n" +
                "      \"genre_ids\": [18, 10752],\n" +
                "      \"id\": 957176,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"De forbandede år 2\",\n" +
                "      \"overview\": \"Under 2. verdenskrig er familien Skov splittet. Sønnen Aksel er hårdkogt medlem af Modstandsbevægelsen, og faderen Karl kæmper for at holde sin virksomhed i gang, og må derfor samarbejde med den tyske besættelsesmagt. Familiens sammenhængskraft er udfordret til det sidste, da krigen endelig slutter.\",\n" +
                "      \"popularity\": 4.6706,\n" +
                "      \"poster_path\": \"/rV4R1YsPywSRDPdRcTerKf5LwCz.jpg\",\n" +
                "      \"release_date\": \"2022-04-21\",\n" +
                "      \"title\": \"De forbandede år 2\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"vote_count\": 21\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/jrrBTFdaacnvCRF6HhTjnR9UX0p.jpg\",\n" +
                "      \"genre_ids\": [28, 18],\n" +
                "      \"id\": 1261050,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"De lydløse\",\n" +
                "      \"overview\": \"I 2008 begår en gruppe mænd fra Danmark og hele Europa det største røveri nogensinde på dansk jord. Kasper, en bokser med få chancer tilbage i livet, bliver tilbudt at planlægge kuppet for de udenlandske bagmænd.\",\n" +
                "      \"popularity\": 4.1541,\n" +
                "      \"poster_path\": \"/gnKFcyBAFYltBgcn4CI5h4I6KRA.jpg\",\n" +
                "      \"release_date\": \"2024-10-31\",\n" +
                "      \"title\": \"De lydløse\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6,\n" +
                "      \"vote_count\": 57\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/sKBB1Fh9YMiLMsUUCPvdcbpVTfo.jpg\",\n" +
                "      \"genre_ids\": [18],\n" +
                "      \"id\": 960206,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Vanskabte land\",\n" +
                "      \"overview\": \"Filmen udspiller sig i slutningen af det 19. århundrede, da en ung dansk præst Lucas bliver udsendt til en fjerntliggende del af Island for at bygge en kirke og fotografere den del af befolkningen, som han møder på sin vej. Men jo dybere han rejser ind i det ubarmhjertige og golde islandske landskab, ledsaget af sin guide, jo mere mister han fornemmelsen af sin egen virkelighed, sin mission og sin pligtopfyldende moral. Da han når frem til den lille bebyggelse, hvor der skaffes plads til ham hos den danske købmand og hans to døtre, sættes hans tro og ærbarhed på en alvorlig prøve.\",\n" +
                "      \"popularity\": 4.6619,\n" +
                "      \"poster_path\": \"/3AE7aZUIOqOI2fP5Im2K38MuiZC.jpg\",\n" +
                "      \"release_date\": \"2022-12-01\",\n" +
                "      \"title\": \"Vanskabte land\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.9,\n" +
                "      \"vote_count\": 178\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/xi9jzA77b05PIQaisdFueFy1GMq.jpg\",\n" +
                "      \"genre_ids\": [35, 18],\n" +
                "      \"id\": 971589,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Kagefabrikken\",\n" +
                "      \"overview\": \"Den midaldrende kagefabrikant Niels er på kanten af et sammenbrud, da hans fabrik er på randen til konkurs. Derfor forsøger hans kone Else at redde fabrikken ved at hjemkalde datteren June og hendes mand Jonny, som foreslår en omfattende modernisering, der har fokus på produktion af sunde kager. Niels kan ikke overskue denne moderniseringsproces og forelsker sig i stedet hovedkulds i fabrikkens nye rengøringsdame, Zeinab.\",\n" +
                "      \"popularity\": 4.0371,\n" +
                "      \"poster_path\": \"/tI9Al5T2jEYvy9djLc0N8RXb1MC.jpg\",\n" +
                "      \"release_date\": \"2023-01-05\",\n" +
                "      \"title\": \"Kagefabrikken\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5,\n" +
                "      \"vote_count\": 11\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/6LtEzA3Umx9mc0lq1g8xOfluGPx.jpg\",\n" +
                "      \"genre_ids\": [10752, 18, 36],\n" +
                "      \"id\": 650031,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Skyggen i mit øje\",\n" +
                "      \"overview\": \"Om morgenen den 21. marts 1945 er nonnerne og skolekammeraterne Rigmor, Eva og Henry fra Den Franske Skole på Frederiksberg klar til at starte skoledagen. Langt derfra - på den anden side af Nordsøen - gør britiske piloter fra Royal Air Force sig klar til en afgørende mission for den danske modstandsbevægelse. De sætter kurs mod Shellhuset, Gestapos Hovedkvarter midt i København. På øverste etage har tyskerne anbragt 26 danske fanger som et levende værn. Angrebet lykkes, men ikke langt derfra rammer tragedien. Et fly er styrtet ned tæt ved Den Franske Skole, og branden får de efterfølgende bombefly til at tro, at målet ligger under røgsøjlen.\",\n" +
                "      \"popularity\": 4.6282,\n" +
                "      \"poster_path\": \"/bxYxzmMkvy9NylvvsxwrFu7WDUg.jpg\",\n" +
                "      \"release_date\": \"2021-10-28\",\n" +
                "      \"title\": \"Skyggen i mit øje\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.836,\n" +
                "      \"vote_count\": 523\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/a2pPepVPtKY7E4XEkT7W3ZxUOY5.jpg\",\n" +
                "      \"genre_ids\": [35, 18],\n" +
                "      \"id\": 580175,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Druk\",\n" +
                "      \"overview\": \"Fire gymnasielærere og venner beslutter sig for at teste en teori om, at mennesket er født med en halv promille for lidt. Teorien lyder, at alkohol i blodet åbner sindet for omverdenen og får kreativiteten til at stige. Resultatet er opsigtsvækkende. Både undervisningen og resultaterne løfter sig, og vennerne begynder for alvor at mærke livet igen. I takt med at genstandene ryger indenbords, skrider eksperimentet fremad for nogle og af sporet for andre. Det bliver tydeligt, at alkohol kan skabe store resultater, men også at den slags vovemod kan have konsekvenser.\",\n" +
                "      \"popularity\": 4.6571,\n" +
                "      \"poster_path\": \"/2GIHLUjKfGgrqoP5F1WxBwG62HO.jpg\",\n" +
                "      \"release_date\": \"2020-09-24\",\n" +
                "      \"title\": \"Druk\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.636,\n" +
                "      \"vote_count\": 3532\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/pERcOAR1Teg4sLDDqRXj1TBjVsn.jpg\",\n" +
                "      \"genre_ids\": [28, 18, 36],\n" +
                "      \"id\": 980026,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Bastarden\",\n" +
                "      \"overview\": \"I 1755 drager den fattige kaptajn Ludvig Kahlen ud for at erobre den ubeboelige danske hede i kongens navn. Men områdets enehersker, den nådesløse Frederik de Schinkel, der mener, at jorden tilhører ham, sværger hævn, da tjenestepigen Ann Barbara og hendes livegne mand flygter for at søge tilflugt hos Kahlen.\",\n" +
                "      \"popularity\": 4.1389,\n" +
                "      \"poster_path\": \"/llXvirrQKyKSmRf9kxYzb7EUWDl.jpg\",\n" +
                "      \"release_date\": \"2023-10-05\",\n" +
                "      \"title\": \"Bastarden\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.699,\n" +
                "      \"vote_count\": 463\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/cTE68uJ57CrhlWz0H0DQ3bABbFt.jpg\",\n" +
                "      \"genre_ids\": [9648, 53, 80, 27],\n" +
                "      \"id\": 1115377,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Englemageren\",\n" +
                "      \"overview\": \"Filmen 'Englemageren' er en psykologisk og brutal thriller, der handler om kriminalbetjenten Laura, som er specialiseret indenfor cyberkriminalitet.  Laura har været sygemeldt med en psykose efter en fødselsdepression, men da hun falder over en sag om en bestialsk seriemorder, vækkes hendes interesse. Hun beslutter sig nu for, at det er på tide at vende tilbage.\",\n" +
                "      \"popularity\": 3.5342,\n" +
                "      \"poster_path\": \"/xkbL9BliHIZN4hjoyQeWt9v1rLY.jpg\",\n" +
                "      \"release_date\": \"2023-06-08\",\n" +
                "      \"title\": \"Englemageren\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.391,\n" +
                "      \"vote_count\": 46\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/7XZsVVnqTsMJXg3J4CHzeV2Lro9.jpg\",\n" +
                "      \"genre_ids\": [28, 35, 18, 53],\n" +
                "      \"id\": 663870,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Retfærdighedens ryttere\",\n" +
                "      \"overview\": \"Den udstationerede militærmand Markus må tage hjem til sin teenagedatter Mathilde, da hans kone dør i en tragisk togulykke. Det ligner en tilfældighed, indtil matematiknørden Otto dukker op med sine to excentriske kollegaer Lennart og Emmenthaler. Otto var selv passager på det forulykkede tog og er overbevist om, nogen må stå bag. Som indicierne hober sig op, står det klart for Markus, at det måske var et nøje orkestreret attentat, som hans kone tilfældigt blev offer for.\",\n" +
                "      \"popularity\": 3.7054,\n" +
                "      \"poster_path\": \"/bjwKt3kqqmptTZwknUHi1nMb3Tq.jpg\",\n" +
                "      \"release_date\": \"2020-11-19\",\n" +
                "      \"title\": \"Retfærdighedens ryttere\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.271,\n" +
                "      \"vote_count\": 955\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/o21lRbAMn0MBlKawSIi3tCEM8K3.jpg\",\n" +
                "      \"genre_ids\": [53],\n" +
                "      \"id\": 990691,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Kærlighed for voksne\",\n" +
                "      \"overview\": \"Den hårfine grænse mellem kærlighed og had bliver livsfarlig, da en dame opdager sin mands affære — og de tager begge ekstreme midler i brug for at få, hvad de vil have.\",\n" +
                "      \"popularity\": 3.3698,\n" +
                "      \"poster_path\": \"/aC6AZYJADlzZem6NF48oOF10LlU.jpg\",\n" +
                "      \"release_date\": \"2022-08-26\",\n" +
                "      \"title\": \"Kærlighed for voksne\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.267,\n" +
                "      \"vote_count\": 332\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/hm5XTB61V9wFqvl5Xtae51jNKIZ.jpg\",\n" +
                "      \"genre_ids\": [35],\n" +
                "      \"id\": 986812,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Fædre & mødre\",\n" +
                "      \"overview\": \"Ægteparret Piv og Ulrik kæmper desperat for at blive inkluderet i deres datters nye klasse på en meget eftertragtet skole. De vil gå meget langt, men det er ikke helt så nemt, når magtstrukturer, dominerende personligheder og traditioner allerede er sat i spil, og slet ikke, når man skal afsted på den årlige hyttetur...\",\n" +
                "      \"popularity\": 3.8424,\n" +
                "      \"poster_path\": \"/dJqhvPkgi5MBy8MTzNU4qEeJbTL.jpg\",\n" +
                "      \"release_date\": \"2022-11-03\",\n" +
                "      \"title\": \"Fædre & mødre\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.735,\n" +
                "      \"vote_count\": 17\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/opNdWurarqYxrzqpVRPyZrbWb3K.jpg\",\n" +
                "      \"genre_ids\": [27, 53, 9648],\n" +
                "      \"id\": 1029880,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Nattevagten - Dæmoner går i arv\",\n" +
                "      \"overview\": \"Martin og hans datter Emma (Fanny Bornedal) kæmper med arven fra det, der skete i kælderen på Retsmedicinsk Institut for knap 30 år siden. Emmas mor, Kalinka, kom sig aldrig over oplevelsen og begik selvmord, da Emma var lille, og i dag lever faren Martin som en skygge af sig selv. Siden dengang har de været hjemsøgt af erindringen om den nat – og i fortielsen er Emma vokset op og har arvet forældrenes traume.  Emma beslutter sig for at udrede, hvad der skete dengang med seriemorderen kriminalinspektør Wörmer, der næsten dræbte hendes forældre. Hun iværksætter et uautoriseret møde med Wörmer i hans isolationscelle. Men oplevelsen trækker den dømte kommissær ud af sin koma og sætter en kæde af skæbnesvangre begivenheder i gang. Nu starter et blodigt hævntogt mod alle dem, som i sin tid beseglede Wörmers skæbne.\",\n" +
                "      \"popularity\": 3.7793,\n" +
                "      \"poster_path\": \"/g9gzoKqS6TpGJIrChiWepq6ydxN.jpg\",\n" +
                "      \"release_date\": \"2023-12-14\",\n" +
                "      \"title\": \"Nattevagten - Dæmoner går i arv\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.335,\n" +
                "      \"vote_count\": 80\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/qi1JnIeecBcj3vh85OKjXd2dWJR.jpg\",\n" +
                "      \"genre_ids\": [878, 18, 10749],\n" +
                "      \"id\": 1053927,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"For evigt\",\n" +
                "      \"overview\": \"Et voldsomt jordskælv skaber en sprække i havbunden. Samtidigt forelsker Elias og Anita sig. Som voksen skal Elias lukke sprækken, men mødet med Anita konfronterer ham med det liv, han valgte fra.\",\n" +
                "      \"popularity\": 2.9664,\n" +
                "      \"poster_path\": \"/cASxZyI3spiUyMrmEPlNyk7i7YP.jpg\",\n" +
                "      \"release_date\": \"2024-07-08\",\n" +
                "      \"title\": \"For evigt\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.7,\n" +
                "      \"vote_count\": 15\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/bFm8SF33iEoUQ2sHZZwHbN3D2yl.jpg\",\n" +
                "      \"genre_ids\": [18, 10752],\n" +
                "      \"id\": 659993,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Erna i krig\",\n" +
                "      \"overview\": \"1918. Første verdenskrig hærger ude i Europa, mens Erna Jensen passer sit jævne liv hjemme i Bramstrup, hvor hun bor med sin enfoldige søn, Kalle. En dag kommer den lokale landbetjent og henter Kalle til krigstjeneste for Det Tyske Kejserrige, som Sønderjylland er en del af. Hvis Erna skal redde Kalle fra den visse død, må hun følge ham i tykt og tyndt. Skæbnen vil, at hun møder en deserterende soldat. De to bytter klæder og identitet, og forklædt som menig Julius Rasmussen drager Erna til fronten. I mødet med de andre soldater og krigens nærvær vækkes ukendte sider af Erna til live. Det er fortællingen om en kvinde, der ikke vil lade en krig forhindre hende i at kæmpe for dét, hun har kært.\",\n" +
                "      \"popularity\": 3.2833,\n" +
                "      \"poster_path\": \"/fvybN2MyxDtwDGTiecSPBjrGNAl.jpg\",\n" +
                "      \"release_date\": \"2020-10-29\",\n" +
                "      \"title\": \"Erna i krig\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.7,\n" +
                "      \"vote_count\": 44\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/q49ZmYf880daaaE23deNLmSMYNg.jpg\",\n" +
                "      \"genre_ids\": [53, 80],\n" +
                "      \"id\": 659940,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"Marco effekten\",\n" +
                "      \"overview\": \"Carl Mørck og Afdeling Q begynder at grave i en henlagt kriminalsag om den efterlyste pædofilisigtede embedsmand, William Stark. Ved den danske grænse har politiet anholdt en ung østeuropæisk dreng, Marco, i besiddelse af Starks pas. Det nye fund bringer Carl Mørck og Afdeling Q på sporet af årelang systematisk korruption med ulandsbistand og mod opklaringen af et bestialsk mord.\",\n" +
                "      \"popularity\": 2.891,\n" +
                "      \"poster_path\": \"/brSUbqkDBzDlH1kmXAaLsSe9meP.jpg\",\n" +
                "      \"release_date\": \"2021-05-27\",\n" +
                "      \"title\": \"Marco effekten\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.7,\n" +
                "      \"vote_count\": 111\n" +
                "    },\n" +
                "    {\n" +
                "      \"adult\": false,\n" +
                "      \"backdrop_path\": \"/uAkUXbAxAPyMkNovSyvHLe13RSU.jpg\",\n" +
                "      \"genre_ids\": [18],\n" +
                "      \"id\": 932355,\n" +
                "      \"original_language\": \"da\",\n" +
                "      \"original_title\": \"København findes ikke\",\n" +
                "      \"overview\": \"København, Danmark. Mens den unge Ida er forsvundet, bliver Sander afhørt af to mænd i en tom lejlighed.\",\n" +
                "      \"popularity\": 2.9587,\n" +
                "      \"poster_path\": \"/sWBpF62uk1PTpc6g6ARpIWtpJFr.jpg\",\n" +
                "      \"release_date\": \"2023-02-09\",\n" +
                "      \"title\": \"København findes ikke\",\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.8,\n" +
                "      \"vote_count\": 9\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total_pages\": 51,\n" +
                "  \"total_results\": 1007\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        MovieResponseDTO expected = objectMapper.readValue(json, MovieResponseDTO.class);
        assertEquals(expected,answer);
    }

    @Test
    void getMoviesWithPeoplesAndGenres() {
    }
}