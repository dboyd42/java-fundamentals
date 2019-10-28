/*
 * Class: Quadratic Equation
 * Descr: This prgm solves a quadratic equation 'ax^2 +bx +c = 0'.
 *      :
*/
class QuadEq {
    // p and q are the roots
    double a, b, c, discriminant, imaginary, p, q, real;

    QuadEq(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
        calcQuadEq();
    }

    private void setA(double first) {
        this.a = first;
    }

    public double getA() {
        return this.a;
    }

    private void setB(double second) {
        this.b = second;
    }

    public double getB() {
        return this.b;
    }

    private void setC(double third) {
        this.c = third;
    }

    public double getC() {
        return this.c;
    }

    private void setDiscriminant(double discrim) {
        this.discriminant = discrim;
    }

    public double getDiscriminant() {
        return this.discriminant;
    }

    private void setImaginary(double i) {
        this.imaginary = i;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    private void setP(double root1) {
        this.p = root1;
    }

    public double getP() {
        return this.p;
    }

    private void setQ(double root2) {
        this.q = root2;
    }

    public double getQ() {
        return this.q;
    }

    private void setReal(double root) {
        this.real = root;
    }

    public double getReal() {
        return this.real;
    }

    private void calcQuadEq() {
        if (getA() == 0.00) {
            setP(0d/0d);  // Set to NaN
            setQ(0d/0d);  // Set to NaN
            setReal(0d/0d);
            setImaginary(0d/0d);
        }

        setDiscriminant(Math.pow(getB(), 2.0) - 4.0 * getA() * getC());

        // condition for real roots
        if (discriminant >= 0.00 ) {
            setP((-getB() + Math.sqrt(getDiscriminant())) / (2.0 * getA()));
            setQ((-getB() - Math.sqrt(getDiscriminant())) / (2.0 * getA()));
        }
        // if roots are not real
        else {
            setP(0d/0d);  // Set to NaN
            setQ(0d/0d);  // Set to NaN
            setReal(-getB() / (2.0 * getA()));
            setImaginary(Math.sqrt(Math.abs(discriminant)) / (2.0 * getA()));
        }
    }

    public void displayRoots() {
        // if roots are complex
        if (Double.isNaN(getP())) {
            System.out.printf("p = %.2f+%.2fi\nq = %.2f-%.2fi",
                   getReal(), getImaginary(), getReal(), getImaginary());
        }
        // if roots are real
        else {
            System.out.printf("p = %.2f\nq = %.2f", getP(), getQ());
        }
    }
}
