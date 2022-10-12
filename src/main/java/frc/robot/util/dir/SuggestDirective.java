package frc.robot.util.dir;

import java.util.List;

public interface SuggestDirective<T> extends Directive {

    void suggest(T t);


    class Impl<T> implements SuggestDirective<T> {

        final List<>

        T lastT;

        public Impl(T initialT) {
            this.lastT = initialT;
        }

        @Override
        public void startupSignal() {

        }

        @Override
        public void periodicSignal() {

        }

        @Override
        public void shutdownSignal() {

        }

        @Override
        public void suggest(T t) {

        }
    }

}
