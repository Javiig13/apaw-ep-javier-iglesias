package es.upm.miw.apaw_ep_javier_iglesias.patterns.Publish;


import org.apache.logging.log4j.LogManager;

public class ObserverB implements Observer {
    private Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update() {
        LogManager.getLogger(this.getClass()).info("Observer B: receiving changes." +
                " Now the office properties are as follows: " + this.subject.getOffice().toString());
    }
}