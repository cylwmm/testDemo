package com.cyl.parten.observe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConcreteSubject extends Subject{
    private String state;

    public void change(String newState) {
        state = newState;
        System.out.println("change state to : " + state);
        this.nodifyObservers(state);
    }
}
