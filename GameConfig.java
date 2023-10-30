package WizardTD;

import java.util.ArrayList;
import java.util.List;

import processing.data.JSONArray;
import processing.data.JSONObject;

public class GameConfig {
    public String layout;
    public List<Wave> waves;
    public int initialTowerRange;
    public float initialTowerFiringSpeed;
    public int initialTowerDamage;
    public int initialMana;
    public int initialManaCap;
    public int initialManaGainedPerSecond;
    public int towerCost;
    public int manaPoolSpellInitialCost;
    public int manaPoolSpellCostIncreasePerUse;
    public float manaPoolSpellCapMultiplier;
    public float manaPoolSpellManaGainedMultiplier;

    public GameConfig(JSONObject config) {
        this.layout = config.getString("layout");

        this.initialTowerRange = config.getInt("initial_tower_range");
        this.initialTowerRange = config.getInt("initial_tower_range");
        this.initialTowerFiringSpeed = config.getFloat("initial_tower_firing_speed");
        this.initialTowerDamage = config.getInt("initial_tower_damage");
        this.initialMana = config.getInt("initial_mana");
        this.initialManaCap = config.getInt("initial_mana_cap");
        this.initialManaGainedPerSecond = config.getInt("initial_mana_gained_per_second");
        this.towerCost = config.getInt("tower_cost");
        this.manaPoolSpellInitialCost = config.getInt("mana_pool_spell_initial_cost");
        this.manaPoolSpellCostIncreasePerUse = config.getInt("mana_pool_spell_cost_increase_per_use");
        this.manaPoolSpellCapMultiplier = config.getFloat("mana_pool_spell_cap_multiplier");
        this.manaPoolSpellManaGainedMultiplier = config.getFloat("mana_pool_spell_mana_gained_multiplier");
        
        JSONArray wavesArray = config.getJSONArray("waves");
        for (int i = 0; i < wavesArray.size(); i++) {
            JSONObject waveObj = wavesArray.getJSONObject(i);
            Wave wave = new Wave(waveObj);
            waves.add(wave);
        }
    }

    public List<Wave> getWaves() {
        return waves;
    }

    public static class Wave {
        public float duration;
        public float preWavePause;
        public List<Monster> monsters = new ArrayList<>();

        public Wave(JSONObject waveObj) {
            this.duration = waveObj.getFloat("duration");
            this.preWavePause = waveObj.getFloat("pre_wave_pause");

            JSONArray monstersArray = waveObj.getJSONArray("monsters");
            for (int i = 0; i < monstersArray.size(); i++) {
                JSONObject monsterObj = monstersArray.getJSONObject(i);
                Monster monster = new Monster(monsterObj);
                monsters.add(monster);
            }
        }

        public static class Monster {
            public String type;
            public int hp;
            public float speed;
            public float armour;
            public int manaGainedOnKill;
            public int quantity;

            public Monster(JSONObject monsterObj) {
                this.type = monsterObj.getString("type");
                this.hp = monsterObj.getInt("hp");
                this.speed = monsterObj.getFloat("speed");
                this.armour = monsterObj.getFloat("armour");
                this.manaGainedOnKill = monsterObj.getInt("mana_gained_on_kill");
                this.quantity = monsterObj.getInt("quantity");
            }
        }
    }
}