public class Customer {

    private int id;

    private int arrival;

    private int enter;

    private int exit;

   private int status;

    public static final int CUST_NOT_PROCESSED = 0; // Assigned value of 0 and means customer has not been processed yet

    public static final int CUST_ENTERED = 1; // Assigned value of 1 and means customer entered the train

    public static final int CUST_EXITED = 2; // Assigned value of 2 and means customer exited the train


    public Customer(int Custid, int arrivalTime, int enterStop, int exitStop) // Constructor method to set attributes passed from Simulator It also sets status attribute to CUST_NOT_PROCESSED

    {
        if (Custid <= 0 || arrivalTime <= 0 || enterStop <= 0 || exitStop <= 0) {
            throw new IllegalArgumentException("Invalid Parameter, please insert a positive number");
        }

                this.id = Custid;

                this.arrival = arrivalTime;

                this.enter = enterStop;

                this.exit = exitStop;

                this.status = CUST_NOT_PROCESSED;


    }


    public void setStatus(int status)
            { // sets passed parameter value as a value of “status” attribute.

            if(status < CUST_NOT_PROCESSED || status > CUST_EXITED) {
                throw new IllegalArgumentException("Invalid value ");
            }

        this.status = status;

    }

    public int getStatus() { // method is called it returns value of status attribute

        return status;

    }

    public int getId() { // method is called it returns value of id attribute.

        return id;

    }

    public int getArrival() { // called it returns value of id attribute.

        return arrival;

    }

    public int getEnter() { // called it returns value of enter attribute

        return enter;

    }

    public int getExit() {// is called it returns value of exit attribute

        return exit;

    }


}

