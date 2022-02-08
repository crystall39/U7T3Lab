import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double sum = 0;
        for (int i = 0; i < check.size(); i++)
        {
            sum += check.get(i).getPrice();
        }
        return sum;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        if (totalPrices() < 40)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < check.size() - 1; i++)
            {
                if (check.get(i).isDailySpecial())
                {
                    return false;
                }
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double tip = 0;
        double discount = 0;
        int customers = 0;
        double original = totalPrices();

        for (int i = 0; i < check.size(); i++)
        {
            if (check.get(i).isEntree())
            {
                customers++;
            }
        }
        if (couponApplies())
        {
            discount = original * 0.25;
        }
        if (customers >= 6)
        {
            tip = original * 0.2;
        }

        return original + tip - discount;
    }
}