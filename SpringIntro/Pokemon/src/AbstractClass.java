
public abstract class AbstractClass implements PokemonInterface {
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon pokemon1=new Pokemon(name, health, type);
		return pokemon1;
	}
	
	public void attackPokemon(Pokemon pokemon1) {
		pokemon1.health-=10;
		System.out.println("New health: "+pokemon1.health);
	}
	public abstract String pokemonInfo(Pokemon pokemon);
	
}
