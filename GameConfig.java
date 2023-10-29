package WizardTD;

import java.util.ArrayList;
import java.util.List;

import processing.core.PImage;
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

        JSONArray wavesArray = config.getJSONArray("waves");
        this.waves = new ArrayList<>();
        for (int i = 0; i < wavesArray.size(); i++) {
            this.waves.add(new Wave(wavesArray.getJSONObject(i)));
        }

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
    }

    public class Wave {
        public int duration;
        public float preWavePause;
        public List<Enemy> enemies;

        public Wave(JSONObject waveObj) {
            this.duration = waveObj.getInt("duration");
            this.preWavePause = waveObj.getFloat("pre_wave_pause");
                
            // Load enemies
            JSONArray enemiesArray = waveObj.getJSONArray("monsters");
            this.enemies = new ArrayList<>();
            for (int i = 0; i < enemiesArray.size(); i++) {
                JSONObject enemyObj = enemiesArray.getJSONObject(i);
                String type = enemyObj.getString("type");
                int hp = enemyObj.getInt("hp");
                float speed = enemyObj.getFloat("speed");
                float armour = enemyObj.getFloat("armour");
                int manaGainedOnKill = enemyObj.getInt("mana_gained_on_kill");
                PImage image = null;
                Enemy enemy = new Enemy(type, hp, speed, armour, manaGainedOnKill, image);
                this.enemies.add(enemy);
            }
        }
    }

}
