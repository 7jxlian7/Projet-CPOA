package vue2D;

import java.util.Collection;

import vue2D.sprites.ISprite;

/**
* Une interface d'une vue
* @author INFO Professors team
*/
public interface IVue extends Collection<ISprite>{
    
    public void dessiner();
    
}
