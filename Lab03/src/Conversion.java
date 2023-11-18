public class Conversion implements Runnable {

    String Url;
    String NameFile;

    public Conversion(String Url) {
        this.Url = Url;
        this.NameFile = this.Url.split("//")[1].replaceAll("\\.", "").replaceAll("/", "-");
        System.out.println(NameFile);
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getNameFile() {
        return NameFile;
    }

    public void setNameFile(String NameFile) {
        this.NameFile = NameFile;
    }
    
    @Override
    public void run() {

        String pathChrome = "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome\"";
        String pathpdf = "\"D:\\Programacion\\Sistemas Distribuidos\\Lab03\\pdf\\" + NameFile + ".pdf\" ";
        try {
            Process process = Runtime.getRuntime()
                    .exec(pathChrome + " --headless --disable-gpu --enable-logging --print-to-pdf="
                            + pathpdf + Url);
            process.waitFor();
            System.out.println("Terminada conversión de: " + NameFile);
            System.out.println("Ubicado en: " + pathpdf);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
