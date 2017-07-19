package dao;

import model.Funcionario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author joaopaulo
 */
public class GsonDAOFuncionario implements IDAO<Funcionario> {

    private final File file;
    private ArrayList<Funcionario> funcionarios = null;

    public GsonDAOFuncionario(String filepath) throws UnsupportedEncodingException, IOException {
        if (funcionarios == null) {
            funcionarios = new ArrayList<>();
        }

        file = new File(filepath);
        if (!file.exists()) {
            file.createNewFile();
        }

        reader();
    }

    @Override
    public boolean insert(Funcionario entity) throws Exception {
        boolean insert = funcionarios.add(entity);

        if (insert) {
            writer();
        }

        return insert;
    }

    @Override
    public void update(int index, Funcionario entity) throws Exception {
        Funcionario f = findByIndex(index);
        f.setNome(entity.getNome());
        f.setCargo(entity.getCargo());
        f.setSalario(entity.getSalario());
        f.setFaltas(entity.getFaltas());
        f.setRegiao(entity.getRegiao());
        f.setBonus(entity.getBonus());
        writer();
    }

    @Override
    public boolean delete(Funcionario entity) throws Exception {
        boolean delete = funcionarios.remove(entity);

        if (delete) {
            writer();
        }

        return delete;
    }

    @Override
    public ArrayList<Funcionario> find() throws Exception {
        return funcionarios;
    }

    @Override
    public Funcionario findByIndex(int index) throws Exception {
        for (Funcionario funcionario : funcionarios) {
            if (index == funcionarios.indexOf(funcionario)) {
                return funcionario;
            }
        }

        return null;
    }

    private void writer() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

        Type type = new TypeToken<ArrayList<Funcionario>>() {
        }.getType();
        String json = gson.toJson(funcionarios, type);
        bw.append(json);
        bw.newLine();
        bw.close();
    }

    private void reader() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Funcionario>>() {
        }.getType();
        while ((line = br.readLine()) != null) {
            funcionarios.addAll(gson.fromJson(line, type));
        }
        br.close();
    }

}
