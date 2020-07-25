package z8;

public class ValidatiorImpl implements Validator {
    @Override
    public boolean validate(Parcel input) {
        boolean flag = false;
        if((input.getXLength() + input.getYLength() + input.getZLength()) < 300) {
            if (input.getXLength() > 30 && input.getYLength() > 30 && input.getZLength() > 30) {
                if (input.getWeight() < 30.0 && !input.isExpress()) {
                    flag = true;
                } else if (input.getWeight() < 15.0 && input.isExpress()) {
                    flag = true;
                } } }
        return flag;
    }
    public static void main(String[] args) {
        ValidatiorImpl v = new ValidatiorImpl();
        System.out.println(v.validate(new Parcel(50,50,50,10, true)));
        System.out.println(v.validate(new Parcel(150,150,50,10, true)));
        System.out.println(v.validate(new Parcel(50,10,50,10, true)));
        System.out.println(v.validate(new Parcel(50,50,50,20, true)));
        System.out.println(v.validate(new Parcel(50,50,50,5, true)));
        System.out.println(v.validate(new Parcel(50,50,50,20, false)));
    }
}
