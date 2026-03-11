package by.drozdovskaya.ft.warehouse;

public class CustomArrayValues {
    private int sum;
    private int max;
    private int min;

    public CustomArrayValues(int sum, int max, int min) {
        this.sum = sum;
        this.max = max;
        this.min = min;
    }

    public int getSum() { return sum; }
    public int getMax() { return max; }
    public int getMin() { return min; }

    public void setSum(int sum) { this.sum = sum; }
    public void setMax(int max) { this.max = max; }
    public void setMin(int min) { this.min = min; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayValues that = (CustomArrayValues) o;
        return sum == that.sum && max == that.max && min == that.min;
    }

    @Override
    public int hashCode() {
        int result = sum;
        result = 31 * result + max;
        result = 31 * result + min;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArrayValues{");
        sb.append("sum=").append(sum);
        sb.append(", max=").append(max);
        sb.append(", min=").append(min);
        sb.append('}');
        return sb.toString();
    }
}