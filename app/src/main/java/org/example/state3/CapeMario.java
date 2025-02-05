package org.example.state3;

public class CapeMario implements IMarioState {
  private MarioStateMachine stateMachine;

  public CapeMario(MarioStateMachine stateMachine) {
    this.stateMachine = stateMachine;
  }

  @Override
  public State getName() {
    return State.CAPE;
  }

  @Override
  public void obtainMushRoom() {
    // do nothing...
  }

  @Override
  public void obtainCape() {
    // do nothing...
  }

  @Override
  public void obtainFireFlower() {
    stateMachine.setCurrentState(new FireMarioState(stateMachine));
    stateMachine.setScore(stateMachine.getScore() + 300);
  }

  @Override
  public void meetMonster() {
    stateMachine.setCurrentState(new SmallMarioState(stateMachine));
    stateMachine.setScore(stateMachine.getScore() - 200);
  }
} 