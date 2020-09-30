package com.example.javafx.component;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class VLCGrid {
    private final VLCComponent[] vlcComponents = new VLCComponent[8];

    public VLCGrid(){
        for (int i = 0; i < 8; i++){
            vlcComponents[i] = new VLCComponent();
        }
    }

    public VLCComponent[] getVlcComponents(){
        return vlcComponents;
    }
}
