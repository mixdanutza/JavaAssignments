

public class Pokedex extends AbstractClass implements PokemonInterface{
	public String pokemonInfo(Pokemon pok) {
		String info="";
		String health=String.valueOf(pok.health);
		info+="Name: "+pok.name+" , Health: "+health+", Type: "+pok.type;
		return info;
	}
	
	
}
