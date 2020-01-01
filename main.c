int main() {
    int i;
    for (i=0; i<100; i=i+1) {
        int k = 123;
        if (k > 150) {
            k = k-i;
        }
        else {
            k = k+i;
        }
    }
    return 0;
}

