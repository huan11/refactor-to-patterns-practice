package org.example.state3;

public class FireMarioState implements IMarioState {
  private MarioStateMachine stateMachine;

  public FireMarioState(MarioStateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public State getName() {
    return State.FIRE;
  }

  @Override
  public void obtainMushRoom() {
    // do nothing...
  }

  @Override
  public void obtainCape() {
    stateMachine.setCurrentState(new CapeMario(stateMachine));
    stateMachine.setScore(stateMachine.getScore() + 200);
  }

  @Override
  public void obtainFireFlower() {
    // do nothing...
  }

  @Override
  public void meetMonster() {
    stateMachine.setCurrentState(new SmallMarioState(stateMachine));
    stateMachine.setScore(stateMachine.getScore() - 300);
  }
} 