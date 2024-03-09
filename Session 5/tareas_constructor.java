public class tareas_constructor {
    public String name_task;
    public int time;
    public String person_responsible;
    public int state;

    public tareas_constructor(String name_task_param, String person_responsible_param, int state_param,
            int time_param) {
        this.name_task = name_task_param;
        this.person_responsible = person_responsible_param;
        this.state = state_param;
        this.time = time_param;
    }

    public String getName_task() {
        return name_task;
    }

    public void setNme_task(String name_task) {
        this.name_task = name_task;
    }

    public String getPerson_responsible() {
        return person_responsible;
    }

    public void setPerson_responsible(String person_responsible) {
        this.person_responsible = person_responsible;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}