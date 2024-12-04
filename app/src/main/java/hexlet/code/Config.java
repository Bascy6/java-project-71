package hexlet.code;

public class Config {
    private String host;
    private int timeout;
    private String proxy;
    private boolean follow;
    private boolean verbose;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public String toString() {
        return "Config{"
                + "host='" + host + '\''
                + ", timeout=" + timeout
                + ", proxy='" + proxy + '\''
                + ", follow=" + follow
                + ", verbose=" + verbose
                + '}';
    }
}
