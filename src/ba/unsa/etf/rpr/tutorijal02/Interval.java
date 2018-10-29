package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double donjaGranica, gornjaGranica;
    boolean donjiInterval,gornjiInterval;
    public Interval(double donjaGranica, double gornjaGranica , boolean donjiInterval, boolean gornjiInterval) throws IllegalArgumentException {
        if(donjaGranica>gornjaGranica) throw new IllegalArgumentException();
        this.donjaGranica = donjaGranica;
        this.gornjaGranica = gornjaGranica;
        this.donjiInterval = donjiInterval;
        this.gornjiInterval = gornjiInterval;
    }
    public Interval(){
        donjaGranica = 0;
        gornjiInterval = false;
        gornjaGranica = 0;
        donjiInterval = false;
    }
    public boolean isNull () {
        return (donjaGranica == gornjaGranica && gornjaGranica == 0 && donjiInterval == gornjiInterval && !donjiInterval) ;
    }
    public boolean isIn (double n) {
        return ((n > donjaGranica && n < gornjaGranica)||(n == donjaGranica && donjiInterval)  || (n == gornjaGranica && gornjiInterval) );
    }
    public Interval intersect (Interval drugi){
        Interval prvi = this;
        if(prvi.donjaGranica > drugi.donjaGranica){
            Interval pomocni = prvi;
            prvi = drugi;
            drugi = pomocni;
        }else if(prvi.donjaGranica == drugi.donjaGranica){
            if(prvi.gornjaGranica < drugi.gornjaGranica)
                return new Interval( prvi.donjaGranica, prvi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, prvi.gornjiInterval);
            else if (drugi.gornjaGranica < prvi.gornjaGranica )
                return new Interval( prvi.donjaGranica, drugi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, drugi.gornjiInterval);
            else
                return new Interval( prvi.donjaGranica, prvi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, prvi.gornjiInterval && drugi.gornjiInterval);
        }
        if(prvi.gornjaGranica < drugi.donjaGranica )
            return new Interval();
        else if (prvi.gornjaGranica == drugi.donjaGranica)
            return new Interval( prvi.gornjaGranica, prvi.gornjaGranica, false , false);
        if(prvi.gornjaGranica < drugi.gornjaGranica)
            return new Interval(drugi.donjaGranica, prvi.gornjaGranica, drugi.donjiInterval, prvi.gornjiInterval);
        else if(prvi.gornjaGranica == drugi.gornjaGranica)
            return new Interval(drugi.donjaGranica, prvi.gornjaGranica, drugi.donjiInterval, prvi.gornjiInterval && drugi.gornjiInterval);
        else return new Interval(drugi.donjaGranica, drugi.gornjaGranica, drugi.donjiInterval, drugi.gornjiInterval);
    }
    public static Interval intersect (Interval prvi, Interval drugi){
        if(prvi.donjaGranica > drugi.donjaGranica){
            Interval pomocni = prvi;
            prvi = drugi;
            drugi = pomocni;
        }else if(prvi.donjaGranica == drugi.donjaGranica){
            if(prvi.gornjaGranica < drugi.gornjaGranica)
                return new Interval( prvi.donjaGranica, prvi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, prvi.gornjiInterval);
            else if (drugi.gornjaGranica < prvi.gornjaGranica )
                return new Interval( prvi.donjaGranica, drugi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, drugi.gornjiInterval);
            else
                return new Interval( prvi.donjaGranica, prvi.gornjaGranica, prvi.donjiInterval && drugi.donjiInterval, prvi.gornjiInterval && drugi.gornjiInterval);
        }
        if(prvi.gornjaGranica < drugi.donjaGranica )
            return new Interval();
        else if (prvi.gornjaGranica == drugi.donjaGranica)
            return new Interval( prvi.gornjaGranica, prvi.gornjaGranica, false , false);
        if(prvi.gornjaGranica < drugi.gornjaGranica)
            return new Interval(drugi.donjaGranica, prvi.gornjaGranica, drugi.donjiInterval, prvi.gornjiInterval);
        else if(prvi.gornjaGranica == drugi.gornjaGranica)
            return new Interval(drugi.donjaGranica, prvi.gornjaGranica, drugi.donjiInterval, prvi.gornjiInterval && drugi.gornjiInterval);
        else return new Interval(drugi.donjaGranica, drugi.gornjaGranica, drugi.donjiInterval, drugi.gornjiInterval);
    }

    public String toString(){
        String pomocni= new String();
        if(!this.isNull()) {
            if (this.donjiInterval)
                pomocni += "[";
            else
                pomocni += "(";
            pomocni += donjaGranica + "," + gornjaGranica;
            if (this.gornjiInterval)
                pomocni += "]";
            else
                pomocni += ")";
            return pomocni;
        }
        return "()";
    }
    public boolean equals(Interval neki){
        return (donjiInterval == neki.donjiInterval && gornjiInterval == neki.gornjiInterval && donjaGranica == neki.donjaGranica && gornjaGranica == neki.gornjaGranica );

    }
    public double getDonjaGranica() {
        return donjaGranica;
    }

    public void setDonjaGranica(double donjaGranica) {
        this.donjaGranica = donjaGranica;
    }

    public double getGornjaGranica() {
        return gornjaGranica;
    }

    public void setGornjaGranica(double gornjaGranica) {
        this.gornjaGranica = gornjaGranica;
    }

    public boolean isDonjiInterval() {
        return donjiInterval;
    }

    public void setDonjiInterval(boolean donjiInterval) {
        this.donjiInterval = donjiInterval;
    }

    public boolean isGornjiInterval() {
        return gornjiInterval;
    }

    public void setGornjiInterval(boolean gornjiInterval) {
        this.gornjiInterval = gornjiInterval;
    }
}

