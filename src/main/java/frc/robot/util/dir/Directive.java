package frc.robot.util.dir;

public interface Directive {

    void startupSignal();
    void periodicSignal();
    void shutdownSignal();

    //will always receive a periodic signal
    //will receive startup signal when starting up (in addition to periodic)
    //will receive shutdown when stopping
    //read user

}
