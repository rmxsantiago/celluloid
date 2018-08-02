package ie.rmxsantiago.data.robots;

import com.google.gson.Gson;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
abstract class BaseRobot {
    protected Gson gson;

    public BaseRobot() {
        gson = new Gson();
    }
}
