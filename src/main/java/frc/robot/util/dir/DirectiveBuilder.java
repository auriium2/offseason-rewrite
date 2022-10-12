package frc.robot.util.dir;

public interface DirectiveBuilder<T> {

    void runOnTransition(T old, T newState, Runnable runnable);
    void runOnStateEnd(T oldState, Runnable runnable);
    void runOnStateBegin(T newState, Runnable runnable);
    void runOnPeriodic(Runnable runnable);

    SuggestDirective<T> build();

    class Impl<T> implements DirectiveBuilder<T> {

        @Override
        public void runOnTransition(T old, T newState, Runnable runnable) {

        }

        @Override
        public void runOnStateEnd(T oldState, Runnable runnable) {

        }

        @Override
        public void runOnStateBegin(T newState, Runnable runnable) {

        }

        @Override
        public void runOnPeriodic(Runnable runnable) {

        }

        @Override
        public SuggestDirective<T> build() {
            return null;
        }
    }


}
